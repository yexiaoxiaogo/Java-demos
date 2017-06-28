package io.github.yexiaoxiaogo.DAOSelect;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	WebsitesDao websitesDao = new WebsitesDaoLmpl();
    	Websites websites =websitesDao.getWebsites(1);
    	System.out.println(websites.getName());
    }
}
