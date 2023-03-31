package com.example.chatapp.Model

class userg
{
    var ProfilePic:String?=null
    var Mail:String?=null
    var UserName:String?=null
    var Password:String?=null
    var UserId:String?=null
    var LastMessage:String?=null
    var Status:String?=null
    constructor(){}
    constructor(Mail:String?,Password: String?,UserName: String?,userid : String?){
        this.Mail=Mail
        this.Password=Password
        this.UserName=UserName
        this.UserId=userid
    }

    @JvmName("getUserId1")
    fun getUserId():String? { return UserId}

     @JvmName("setUserId1")
     fun  setUserId(id:String)  {  this.UserId=id}
    @JvmName("getUserName1")
    fun  getUserName() : String? { return UserName}
    @JvmName("setUserName1")
    fun  setUserName(name:String) { this.UserName =name}
    @JvmName("getProfilePic1")
    fun  getProfilePic() : String? { return ProfilePic}
    @JvmName("setProfilePic1")
    fun  setProfilePic(profilePic:String) { this.ProfilePic=profilePic}


}