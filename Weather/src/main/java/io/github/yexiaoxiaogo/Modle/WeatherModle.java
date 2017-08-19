/**
 * 
 */
/**
 * @author 84107
 *
 */
package io.github.yexiaoxiaogo.Modle;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;





@Entity
@Table(name = "weather")
public class WeatherModle{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "CITYNAME")
	private String ctiyName;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "ZIPCODE")
	private int zipcode;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "weatherModle",cascade = CascadeType.ALL)
	private Set<WeatherDataModle> weatherData =  new HashSet<WeatherDataModle>(0);
	
	public Set<WeatherDataModle> getWeatherData(){
		return weatherData;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCtiyName() {
		return ctiyName;
	}

	public void setCtiyName(String ctiyName) {
		this.ctiyName = ctiyName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
}
