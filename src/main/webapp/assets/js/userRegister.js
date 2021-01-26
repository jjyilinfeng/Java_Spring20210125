const messCode = ["q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m",
    "A", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", "V", "B", "N", "M",
    "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"];

function getCode(size){
    const codeLen = messCode.length;
    let code = "";
    for(var i = 0;i < size;i++){
        let randIdx = Math.floor(Math.random()*codeLen)
        code += messCode[randIdx];
    }
    return code;
}

//创建Vue实例,得到 ViewModel
var app = new Vue({
    el: '#app',
    data: {
        username:"",
        password:"",
        userEmail:"",
        username_msg:"",
        checkCodeData:[
            "","","","","",""
        ],
        checkCode:"",
        checkCodeConfirm:"",
        usernameGate:false,
        userPasswordGate:false,
        userEmailGate:false,
        userCheckCodeGate:false,
    },/*数据*/
    component:{},/*自定义标签*/
    mounted(){
        toastr.options = {
            closeButton: false,
            debug: false,
            progressBar: false,
            positionClass: "toast-top-center",
            onclick: null,
            showDuration: "300",
            hideDuration: "1000",
            timeOut: "2500",
            extendedTimeOut: "1000",
            showEasing: "swing",
            hideEasing: "linear",
            showMethod: "fadeIn",
            hideMethod: "fadeOut"
        };
    },/*自动加载函数*/
    methods: {
        pwdStrength:function(){
            const pwd = this.password;
            let pwdstr = 0;
            let passwordStrengthBar = $("#password-bar");
            const pattNum = new RegExp(/^.*[\d]+.*$/);
            const pattLetterLow = new RegExp(/.*[a-z]+.*$/);
            const pattLetterUpper = new RegExp(/.*[A-Z]+.*$/);
            const pattSpecial = new RegExp(/.*[`~!@#$%^&*()_\-+=<>?:"{}|,.\/;'\\[\]·]+.*$/);
            if(pwd.length > 3 && pwd.length < 31){
                if(pattNum.test(pwd)){
                    pwdstr++;
                }
                if(pattLetterLow.test(pwd)){
                    pwdstr++;
                }
                if(pattLetterUpper.test(pwd)){
                    pwdstr++;
                }
                if(pattSpecial.test(pwd)){
                    pwdstr++;
                }
            }
            switch(pwdstr){
                case 0:
                    if(passwordStrengthBar.css("width") !== "0"){
                        passwordStrengthBar.attr("class","progress-bar progress-bar-danger");
                        passwordStrengthBar.animate({width:"0"},40);
                    }
                    break;
                case 1:
                    if(passwordStrengthBar.css("width") !== "37.5px"){
                        passwordStrengthBar.attr("class","progress-bar progress-bar-danger");
                        passwordStrengthBar.animate({width:"37.5px"},40);
                    }
                    break;
                case 2:
                    if(passwordStrengthBar.css("width") !== "82.5px"){
                        passwordStrengthBar.attr("class","progress-bar progress-bar-warning");
                        passwordStrengthBar.animate({width:"82.5px"},40);
                    }
                    break;
                case 3:
                    if(passwordStrengthBar.css("width") !== "120px"){
                        passwordStrengthBar.attr("class","progress-bar progress-bar-success");
                        passwordStrengthBar.animate({width:"120px"},40);
                    }
                    break;
                case 4:
                    if(passwordStrengthBar.css("width") !== "150px"){
                        passwordStrengthBar.attr("class","progress-bar progress-bar-success");
                        passwordStrengthBar.animate({width:"150px"},100);
                    }
                    break;
                default:
                    console.log("密码强度错误");
                    break;
            }
        },
        uNameJug:function(){
            let uname = this.username;
            if(uname.length < 2 || uname.length > 16){
                $("#username_group").attr("class","form-group has-error");
                toastr.error("用户名输入格式错误");
                this.usernameGate = false;
            }
            else{
                axios.post("/admin/RegisterServlet", Qs.stringify({'style':"userNameRenameJudge",'username':app.username,'userEmail':app.userEmail}))
                    .then(res => {
                        const data = res.data;
                        if(data.code === 300){
                            $("#username_group").attr("class","form-group has-error");
                            toastr.error("用户名已被使用");
                            this.usernameGate = false;
                        }
                        else{
                            $("#username_group").attr("class","form-group has-success");
                            toastr.success("该用户名可以被使用");
                            this.usernameGate = true;
                        }
                    })
                    .catch(err => {
                        console.error(err);
                    })
            }
        },
        uPwdJug:function(){
            if(this.password.length > 20 || this.password.length < 4){
                this.userPasswordGate = false;
                toastr.error("密码格式不正确");
            }
            else{
                this.userPasswordGate = true;
            }
        },
        uEmailJug:function(){
            let patterEmail = RegExp(/^\w+@[a-zA-Z0-9]{2,10}(?:\.[a-z]{2,4}){1,3}$/)
            if(patterEmail.test(this.userEmail)){
                axios.post("/admin/RegisterServlet", Qs.stringify({'style':"emailRenameJudge",'username':app.username,'userEmail':app.userEmail}))
                    .then(res => {
                        const data = res.data;
                        if(data.code === 301){
                            $("#userEmail_group").attr("class","form-group has-error");
                            toastr.error("邮箱已被使用");
                            this.userEmailGate = false;
                        }
                        else{
                            $("#userEmail_group").attr("class","form-group has-success");
                            toastr.success("该邮箱可以被使用");
                            this.userEmailGate = true;
                        }
                    })
                    .catch(err => {
                        console.error(err);
                    })
            }
            else{
                $("#userEmail_group").attr("class","form-group has-error");
                toastr.error("邮箱格式不正确");
                this.userEmailGate = false;
            }
        },
        doRegister:function(){
            let code = "";
            for(let i = 0; i < this.checkCodeData.length; i++){
                code += this.checkCodeData[i];
            }

            if(code === this.checkCodeConfirm){
                axios.post("/admin/RegisterServlet", Qs.stringify({'style':"register",'username':app.username,'password':app.password,'userEmail':app.userEmail}))
                    .then(res => {
                        const data = res.data;
                        if(data.code === 303){
                            $("#userEmail_group").attr("class","form-group has-error");
                            toastr.success("注册成功,将在三秒后跳转至登录界面");
                            setTimeout(function(){
                                location.href = "/login.html"
                            },3000);
                        }
                        else{
                            $("#userEmail_group").attr("class","form-group has-success");
                            toastr.error("注册失败");
                        }
                    })
                    .catch(err => {
                        console.error(err);
                    })
            }else{
                toastr.error("验证码不正确");
                for(let i = 0;i < this.checkCodeData.length;i++){
                    this.$set(this.checkCodeData, i, "");
                }
                this.$refs['c0'].focus();
            }
        },
        goNext:function(idx){
            let index = parseInt(idx);
            if(this.checkCodeData[index].length > 0){
                this.$refs['c'+(index+1)].focus();
            }
        },
        getMailCode:function(){
            if(this.usernameGate && this.userPasswordGate && this.userEmailGate){
                this.checkCodeConfirm = getCode(6);
                this.openMsgBox()
                axios.post("/admin/RegisterServlet", Qs.stringify({'style':"sendMail",'checkCode':app.checkCodeConfirm,'userEmail':app.userEmail}))
                    .then(res => {
                        toastr.warning("验证码邮件已经成功发送至您的邮箱，请注意查收");
                    })
                    .catch(err => {
                        console.error(err);
                    })
            }
            else{
                toastr.warning("输入的信息不正确");
            }
        },
        openMsgBox:function(){
            $(".chaos").css("display","inline");
            $(".msgBox").fadeIn();
        },
        closeMsgBox:function(){
            $(".msgBox").fadeOut();
            $(".chaos").css("display","none");
        }
    },/*执行触发函数*/
    computed: {

    },/*动态计算属性*/
});