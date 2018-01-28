package com.csp.trends.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "sub_category")
public class SubCategoryDTO implements Serializable {

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "sub_category_id")
	private int subCategoryId;
	@Column(name = "sub_category_name")
	private String subCategoryName;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "category_id")
	private CategoryDTO categoryDTO;
	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "subCategoryDTO")
	private List<ProductDTO> productDTO;

	
	public int getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public String getSubCategoryName() {
		return subCategoryName;
	}
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	public CategoryDTO getCategoryDTO() {
		return categoryDTO;
	}
	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}
	public List<ProductDTO> getProductDTO() {
		return productDTO;
	}
	public void setProductDTO(List<ProductDTO> productDTO) {
		this.productDTO = productDTO;
	}
	
	/*@Override
	public String toString() {
		return "SubCategoryDTO [subCategoryId=" + subCategoryId + ", subCategoryName=" + subCategoryName
				+ ", subCategoryDTO=" + categoryDTO + ", productDTO=" + productDTO + "]";
	}*/
	public SubCategoryDTO() {

		System.out.println(this.getClass().getSimpleName() + " object created");
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryDTO == null) ? 0 : categoryDTO.hashCode());
		result = prime * result + ((productDTO == null) ? 0 : productDTO.hashCode());
		result = prime * result + subCategoryId;
		result = prime * result + ((subCategoryName == null) ? 0 : subCategoryName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubCategoryDTO other = (SubCategoryDTO) obj;
		if (categoryDTO == null) {
			if (other.categoryDTO != null)
				return false;
		} else if (!categoryDTO.equals(other.categoryDTO))
			return false;
		if (productDTO == null) {
			if (other.productDTO != null)
				return false;
		} else if (!productDTO.equals(other.productDTO))
			return false;
		if (subCategoryId != other.subCategoryId)
			return false;
		if (subCategoryName == null) {
			if (other.subCategoryName != null)
				return false;
		} else if (!subCategoryName.equals(other.subCategoryName))
			return false;
		return true;
	}
		
	

	
}
