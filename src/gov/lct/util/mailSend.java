package gov.lct.util;

public class mailSend {

	//public static void main(String[] args){
        //sendMail("cm8295@163.com", "casit设置邮http://www.baidu.com箱标题123", "casit设置邮箱  http://www.baidu.com  内容1");
	//	sendMail1();
	//}
	
	/**
	 * 功能：发送邮件
	 * 参数：_mail:邮箱，_Subject:主题，_content:内容
	 * 
	 * */
	public void sendMail(String _mail, String _Subject, String _content){
		//这个类主要是设置邮件
		MailSenderInfo mailInfo = new MailSenderInfo(); 
		mailInfo.setMailServerHost("smtp.cstnet.cn"); 
		mailInfo.setMailServerPort("25"); 
		mailInfo.setValidate(true); 
		mailInfo.setUserName("chenming@casit.com.cn"); 
		mailInfo.setPassword("CMcasit0909");//您的邮箱密码 
		mailInfo.setFromAddress("chenming@casit.com.cn"); 
		mailInfo.setToAddress(_mail); 
		mailInfo.setSubject(_Subject); 
		mailInfo.setContent(_content); 
	    //这个类主要来发送邮件
		SimpleMailSender sms = new SimpleMailSender();
	    sms.sendTextMail(mailInfo);//发送文体格式 
	    //sms.sendHtmlMail(mailInfo);//发送html格式
	}
}
