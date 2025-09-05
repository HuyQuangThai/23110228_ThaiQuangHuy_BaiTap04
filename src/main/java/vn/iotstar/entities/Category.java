package vn.iotstar.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


@Entity
@Table(name = "categories")
@NamedQuery(name="Category.findAll",query="SELECT c FROM Category c")
public class Category implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	@Column(name = "categoryName", columnDefinition = "NVARCHAR(255)") //Định nghĩa tiếng việt
	private String categoryname;
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String images;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the categoryname
	 */
	public String getCategoryname() {
		return categoryname;
	}
	/**
	 * @param categoryname the categoryname to set
	 */
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	/**
	 * @return the images
	 */
	public String getImages() {
		return images;
	}
	/**
	 * @param images the images to set
	 */
	public void setImages(String images) {
		this.images = images;
	}
}
