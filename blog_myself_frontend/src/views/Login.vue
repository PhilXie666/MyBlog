<template>
    <div>

        <a-form-model
                method="post"
                :layout="form.layout" :model="form" v-bind="formItemLayout">
            <!--<a-form-model-item label="Form Layout">
                <a-radio-group v-model="form.layout">
                    <a-radio-button value="horizontal">
                        Horizontal
                    </a-radio-button>
                    <a-radio-button value="vertical">
                        Vertical
                    </a-radio-button>
                    <a-radio-button value="inline">
                        Inline
                    </a-radio-button>
                </a-radio-group>
            </a-form-model-item>-->
            <a-form-model-item label="用户名">
                <a-input v-model="form.username" placeholder="input placeholder" />
            </a-form-model-item>
            <a-form-model-item label="密码">
                <a-input v-model="form.password" placeholder="input placeholder" />
            </a-form-model-item>
            <a-form-model-item :wrapper-col="buttonItemLayout.wrapperCol">
                <a-button type="primary" @click="login">
                    登录
                </a-button>
            </a-form-model-item>
        </a-form-model>

    </div>


</template>

<script>
    export default {
        name: "Login.vue",
        data() {
            return {
                form: {
                    layout: 'horizontal',
                    username: '',
                    password: '',
                },
            };
        },
        computed: {
            formItemLayout() {
                const { layout } = this.form;
                return layout === 'horizontal'
                    ? {
                        labelCol: { span: 4 },
                        wrapperCol: { span: 14 },
                    }
                    : {};
            },
            buttonItemLayout() {
                const { layout } = this.form;
                return layout === 'horizontal'
                    ? {
                        wrapperCol: { span: 14, offset: 4 },
                    }
                    : {};
            },
        },
        methods: {
            // 登录
            login() {
                var that = this
                this.$axios({
                    method: 'post',
                    url: 'http://localhost:8081/user/login',
                    data: {
                        username: this.form.username,
                        password: this.form.password,
                    },
                    header:{
                        'Content-Type':'application/json'
                    }

                }).then(function (res) {
                    console.log("后台返回：")
                    console.log(res)
                    if (res.data === 'success') {
                        // 登录成功，跳转到首页

                        that.$router.push('/index')

                    }
                })

                /*this.$axios({
                    method: 'post',
                    url: 'http://localhost:8081/login?username=xwx&password=123456',

                }).then(function (res) {
                    console.log("后台返回：")
                    console.log(res)
                })*/
            },

        }
    }
</script>

<style scoped>

</style>
