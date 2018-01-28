package com.csp.trends.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "category")
public class CategoryDTO implements Serializable {

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "category_id")
	private int categoryId;
	@Column(name = "category_name")
	private String categoryName;
	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "categoryDTO")
	private List<SubCategoryDTO> subCategoryDTO;
	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "categoryDTO")
	private List<ProductDTO> productDTO;

	public List<ProductDTO> getProductDTO() {
		return productDTO;
	}

	public void setProductDTO(List<ProductDTO> productDTO) {
		this.productDTO = productDTO;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<SubCategoryDTO> getSubCategoryDTO() {
		return subCategoryDTO;
	}

	public void setSubCategoryDTO(List<SubCategoryDTO> subCategoryDTO) {
		this.subCategoryDTO = subCategoryDTO;
	}

	/*@Override
	public String toString() {
		return "CategoryDTO [categoryId=" + categoryId + ", categoryName=" + categoryName + ", subCategoryDTO="
				+ subCategoryDTO + "]";
	}*/

	public CategoryDTO() {
		System.out.println(this.getClass().getSimpleName() + " object created");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryId;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + ((productDTO == null) ? 0 : productDTO.hashCode());
		result = prime * result + ((subCategoryDTO == null) ? 0 : subCategoryDTO.hashCode());
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
		CategoryDTO other = (CategoryDTO) obj;
		if (categoryId != other.categoryId)
			return false;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (productDTO == null) {
			if (other.productDTO != null)
				return false;
		} else if (!productDTO.equals(other.productDTO))
			return false;
		if (subCategoryDTO == null) {
			if (other.subCategoryDTO != null)
				return false;
		} else if (!subCategoryDTO.equals(other.subCategoryDTO))
			return false;
		return true;
	}

	
	
	

}
