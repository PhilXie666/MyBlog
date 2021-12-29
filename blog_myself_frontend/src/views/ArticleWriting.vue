<template>

    <div>
        文章标题：<a-input v-model="article.title"></a-input>
        文章内容：
        <MyRichText
                :text="article.content"
                @editorChange="editorChange"
        ></MyRichText>
        <a-button
                type="primary"
                @click="articleSave"
        >
            提交
        </a-button>
    </div>

</template>

<script>
    import MyRichText from "../views/common/my-rich-text"
    export default {
        name: "ArticleWriting.vue",
        components: { MyRichText },
        data () {
            return {
                // 文章
                article: {
                    title: "",
                    content: ""
                },
            }
        },
        methods: {
            editorChange(html) {
                this.article.content = html

                console.log("富文本编辑器内容发生变化：")
                console.log(this.article.content)
            },
            articleSave() {
                var that = this
                this.$axios({
                    method: "post",
                    url: "http://localhost:8081/article/saveArticle",
                    data: {
                        title: that.article.title,
                        content: that.article.content
                    },
                    header:{
                        'Content-Type':'application/json'
                    }
                }).then(function (res) {
                    console.log(res)
                })
            }
        }
    }
</script>

<style scoped>

</style>
