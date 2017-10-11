var container = new Vue({
    el: '#container',
    data:{
      message: null,
      username: null,
      password: null,
      token: null,
    },

    methods:{

      submit: function(){

        console.log("Username: "+this.username+" - Password: "+this.password);
        //                                value           salt
          var encrypted = encrypt(this.password, this.username)

          var body = {username:this.username, password: ""+encrypted+""}

          console.log(body)

          $.ajax({
              url: "/login/"+this.username,
              headers: {
                  'Accept': 'text/plain',
                  //'Content-Type': 'application/json',
                  //'Access-Control-Allow-Origin':true,
                  username: this.username,
                  password: ""+encrypted+""
              },
              success: function (data) {
                  console.log("Success")
                  if(data) {
                      console.log("Log in successful")
                      console.log(data)

                      container.token = data;

                      container.message = "Log in successful!";
                  }
                  else {
                      container.message = "Log in Failed!";
                  }
              },
              error: function (data) {
                  console.log(data)
                  container.message = "Log in Failed!";
              }
          });




        //this.username = null;
        //this.password = null;
      },
        create: function () {

            console.log("Username: "+this.username+" - Password: "+this.password);
            //                                value           salt
            var encrypted = encrypt(this.password, this.username)
            var body = JSON.stringify({username:this.username, password: ""+encrypted+""})

            console.log(body)

            fetch("/login/", {

                method: "post",
                headers:{
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                    "Access-Control-Allow-Origin":true
                },
                body: body

            }).then(function(res){

                if(res.ok) {
                    console.log("User Created Successfully")
                    container.message = "User Created Successfully!";
                }
                else {
                    container.message = "User Not Created";
                }
            })

            //this.username = null;
            //this.password = null;

        },
        testToken: function () {

            var token = container.token;
            console.log("Token is: "+token)

            $.ajax({
                url: "/login/"+this.username+"/test",
                headers: {
                    'Accept': 'text/plain',
                    //'Content-Type': 'application/json',
                    //'Access-Control-Allow-Origin':true,
                    username: this.username,
                    token: token
                },
                success: function (data) {

                    console.log(data)

                    container.message = "Token Accepted!";

                },
                error: function (data) {
                    console.log(data)
                    container.message = "Token Not Accepted!";

                }
            });

        }
    }
})

function encrypt(toEncrypt, salt) {

    return CryptoJS.PBKDF2(toEncrypt, salt, { keySize: 160, iterations: 200 });

}