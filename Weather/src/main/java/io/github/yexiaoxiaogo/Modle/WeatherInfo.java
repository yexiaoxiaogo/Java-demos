package io.github.yexiaoxiaogo.Modle;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.tomcat.util.modeler.BaseModelMBean;

@Entity
@Table(name = "weather_info")
public class WeatherInfo extends BaseModelMBean implements Serializable {
	

}
