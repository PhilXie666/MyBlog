<template>

    <a-layout id="components-layout-demo-top-side-2">
        <a-layout-header class="header">
            <div class="logo" />
            <a-menu
                    theme="dark"
                    mode="horizontal"
                    :default-selected-keys="['2']"
                    :style="{ lineHeight: '64px' }"
            >
                <a-menu-item key="1">
                    nav 1
                </a-menu-item>
                <a-menu-item key="2">
                    nav 2
                </a-menu-item>
                <a-menu-item key="3">
                    nav 3
                </a-menu-item>
            </a-menu>
        </a-layout-header>
        <a-layout>
            <a-layout-sider width="200" style="background: #fff">
                <a-menu
                        mode="inline"
                        :default-selected-keys="['1']"
                        :default-open-keys="['sub1']"
                        :style="{ height: '100%', borderRight: 0 }"
                >
                    <a-sub-menu key="sub1">
                        <span slot="title"><a-icon type="user" />subnav 1</span>
                        <a-menu-item key="1">
                            option1
                        </a-menu-item>
                        <a-menu-item key="2">
                            option2
                        </a-menu-item>
                        <a-menu-item key="3">
                            option3
                        </a-menu-item>
                        <a-menu-item key="4">
                            option4
                        </a-menu-item>
                    </a-sub-menu>
                    <a-sub-menu key="sub2">
                        <span slot="title"><a-icon type="laptop" />subnav 2</span>
                        <a-menu-item key="5">
                            option5
                        </a-menu-item>
                        <a-menu-item key="6">
                            option6
                        </a-menu-item>
                        <a-menu-item key="7">
                            option7
                        </a-menu-item>
                        <a-menu-item key="8">
                            option8
                        </a-menu-item>
                    </a-sub-menu>
                    <a-sub-menu key="sub3">
                        <span slot="title"><a-icon type="notification" />subnav 3</span>
                        <a-menu-item key="9">
                            option9
                        </a-menu-item>
                        <a-menu-item key="10">
                            option10
                        </a-menu-item>
                        <a-menu-item key="11">
                            option11
                        </a-menu-item>
                        <a-menu-item key="12">
                            option12
                        </a-menu-item>
                    </a-sub-menu>
                </a-menu>
            </a-layout-sider>
            <a-layout style="padding: 0 24px 24px">
                <a-breadcrumb style="margin: 16px 0">
                    <a-breadcrumb-item>Home</a-breadcrumb-item>
                    <a-breadcrumb-item>List</a-breadcrumb-item>
                    <a-breadcrumb-item>App</a-breadcrumb-item>
                </a-breadcrumb>
                <a-layout-content
                        :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
                >
                    <a-card
                            :title="article.title"
                    >
                        <!--发布时间-->
                        <a-card-meta
                                :description="article.publishTime"
                        >
                        </a-card-meta>
                            <br />
                            <br />
                        <!--文章具体内容-->
                        <!--<div id="article_content">
                        <a-card-meta
                                :description="article.content"
                        >
                        </a-card-meta></div>-->
                        <!--<div>
                            <p>
                            </p>
                            &lt;!&ndash;<div v-html="img_html"></div>
                            <img src="000001.png">&ndash;&gt;
                        </div>-->

                        <!--文章具体内容-->
                        <!--<img src="../static/000001.png">-->

                        <!--<div id="article_content_id">
                            ${}
                        </div>-->

                        <div v-html="article_content_html">


                        </div>

                    </a-card>
                </a-layout-content>
            </a-layout>
        </a-layout>
    </a-layout>

</template>

<style scoped>
    #components-layout-demo-top-side-2 .logo {
        width: 120px;
        height: 31px;
        background: rgba(255, 255, 255, 0.2);
        margin: 16px 28px 16px 0;
        float: left;
    }
    #article_content {
        color: black;
    }

</style>



<script>
    export default {
        name: "Index.vue",
        data() {
            return {
                collapsed: false,
                // 文章
                article: {
                    title: "",// 文章标题
                    publish_time: "",// 发布时间
                    content: "",// 文章内容

                    // 文章的图片
                    pictures: []
                },
                article_content_html: "<h1>这是测试</h1>"
            };
        },
        created() {
            this.getNewestArticle()
        },
        methods: {
            // 获取最新的一篇文章
            getNewestArticle() {
                var that = this
                this.$axios.get("http://localhost:8081/article/getNewestArticle").then(function (res) {
                    if (res.data.success) {
                        console.log("获取最新的一篇文章……")
                        console.log(res.data)
                        that.article = res.data.data;// 文章对象直接赋值

                        that.article_content_html = that.article.content

                        // that.insertAnArtPictures(that.article.id)
                    }

                })
            },

            // 在文章中的文字中插入这篇文章的所有图片
            insertAnArtPictures(article_id) {
                var that = this
                this.$axios.get("http://localhost:8081/article/selectAnArtPictures", {
                    params: {
                        id: article_id
                    }
                }).then(function (res) {
                    that.article["pictures"] = res.data.data;

                    that.composeArticleContent()

                    console.log("一篇文章的所有图片信息……")
                    console.log(that.article["pictures"])
                    // that.img_html = "<img src=\"" + "000001.png"+ "\">"
                })
            },

            // 文章具体内容拼接
            composeArticleContent() {
                var article_content = this.article.content
                var len = this.article.pictures.length
                for (let i = 0; i < len; i++) {// 处理文章的每张图片
                    let img_str = "</p>" + "{img[" + i + "]}" + "<p>"
                    article_content = this.insertStr(article_content, this.article.pictures[i].wordsNum, img_str)
                    // 所有图片在文章中的位置往后挪（插入的{img[i]}长度为8）
                    this.movePicPositions(i, img_str.length)
                }
                // 替换{img[i]}为每张图片具体的img标签
                for (let i = 0; i < len; i++) {
                    let img_str = "{img[" + i + "]}"
                    let img_real_path = "<img width='800px' src=\"" + this.article.pictures[i].path + "\">"
                    article_content = article_content.replace(img_str, img_real_path)
                }
                // 完善未配对的</p>或<p>标签
                // 也就是在字符串article_content开头位置插入<p>标签，在
                // article_content结尾位置插入</p>标签
                article_content = this.insertStr(article_content, 0, "<p>")
                article_content = this.insertStr(article_content, article_content.length, "</p>")

                // 赋值给html
                this.article_content_html = article_content

                console.log("插入图片后的文章内容……")
                console.log(article_content)
            },

            // 在字符串指定位置插入字符串
            insertStr(soure, start, newStr){
                return soure.slice(0, start) + newStr + soure.slice(start)
            },

            // 所有图片在文章中的位置往后挪
            // pic_index: 文章内容拼接到了第几张图片
            // move_num: 图片位置的移动量
            movePicPositions(pic_index, move_num) {
                var len = this.article.pictures.length
                for (var i = pic_index + 1; i < len; i++) {
                    this.article.pictures[i].wordsNum += move_num
                }
            }
        }
    }
</script>




















