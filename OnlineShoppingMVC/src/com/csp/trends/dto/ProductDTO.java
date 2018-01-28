package com.csp.trends.dto;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "product")
public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "product_id")
	private int productId;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "product_price")
	private double productPrice;
	@Column(name = "product_qty")
	private int productQuantity;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "company_id")
	private CompanyDTO companyDTO;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "category_id")
	private CategoryDTO categoryDTO;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "sub_category_id")
	private SubCategoryDTO subCategoryDTO;
	@Column(name = "product_desc")
	private String description;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice2) {
		this.productPrice = productPrice2;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public CompanyDTO getCompanyDTO() {
		return companyDTO;
	}

	public void setCompanyDTO(CompanyDTO companyDTO) {
		this.companyDTO = companyDTO;
	}

	public CategoryDTO getCategoryDTO() {
		return categoryDTO;
	}

	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}

	public SubCategoryDTO getSubCategoryDTO() {
		return subCategoryDTO;
	}

	public void setSubCategoryDTO(SubCategoryDTO subCategoryDTO) {
		this.subCategoryDTO = subCategoryDTO;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productQuantity=" + productQuantity + ", companyDTO=" + companyDTO + ", categoryDTO=" + categoryDTO
				+ ", subCategoryDTO=" + subCategoryDTO + ", description=" + description + "]";
	}

	public ProductDTO() {

		System.out.println(this.getClass().getSimpleName() + " object created");

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryDTO == null) ? 0 : categoryDTO.hashCode());
		result = prime * result + ((companyDTO == null) ? 0 : companyDTO.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + productId;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(productPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + productQuantity;
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
		ProductDTO other = (ProductDTO) obj;
		if (categoryDTO == null) {
			if (other.categoryDTO != null)
				return false;
		} else if (!categoryDTO.equals(other.categoryDTO))
			return false;
		if (companyDTO == null) {
			if (other.companyDTO != null)
				return false;
		} else if (!companyDTO.equals(other.companyDTO))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (productId != other.productId)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (Double.doubleToLongBits(productPrice) != Double.doubleToLongBits(other.productPrice))
			return false;
		if (productQuantity != other.productQuantity)
			return false;
		if (subCategoryDTO == null) {
			if (other.subCategoryDTO != null)
				return false;
		} else if (!subCategoryDTO.equals(other.subCategoryDTO))
			return false;
		return true;
	}

	
	
}
