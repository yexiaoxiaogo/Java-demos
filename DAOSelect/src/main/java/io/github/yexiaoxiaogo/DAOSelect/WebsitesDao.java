package io.github.yexiaoxiaogo.DAOSelect;

import java.util.List;

public interface WebsitesDao {
	public List<Websites> getAllWebsties();
	public Websites getWebsites(int id);
	public void updateWebsites(Websites websites);
	public void deleteWebsites(Websites websites);

}
