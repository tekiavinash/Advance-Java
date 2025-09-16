package pack1;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener,HttpSessionAttributeListener
{
	@Override
	public void sessionCreated(HttpSessionEvent se) 
	{
		System.out.println("Session Created");
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent se) 
	{
		System.out.println("Session Destroyed");
	}
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) 
	{
		System.out.println("Attribute added to the Session");
	}
	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) 
	{
		System.out.println("Attribute removed by the Session");
	}
}
