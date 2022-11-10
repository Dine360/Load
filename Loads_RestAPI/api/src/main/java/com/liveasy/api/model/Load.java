package com.liveasy.api.model;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="loads")
public class Load {
    
	@Id
    @SequenceGenerator(name = "id_generator", sequenceName = "load_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private int id;

	@Column(name="loading_point")
    private String loadingPoint;

    @Column(name="unloading_point")
    private String unLoadingPoint;

    @Column(name="product_type")
    private String productType;
    
    @Column(name="truck_type")
    private String truckType;
    
    @Column(name="no_of_truck")
    private int noOfTruck;
    
    @Column(name="weight")
    private double weight;
    
    @Column(name="date_of_booking")
    private Date dateOfBooking;
    
    @Column(name="comments")
    private String comments;
    
 
    @Type(type = "pg-uuid")
    @Column(name = "shipper_id", columnDefinition = "uuid")
    private UUID shipperId;

	public Load() {
    }

    public Load(int id, String loadingPoint, String unLoadingPoint, String productType, String truckType, int noOfTruck,
			double weight, Date dateOfBooking, String comments) {
		super();
		this.id = id;
		this.loadingPoint = loadingPoint;
		this.unLoadingPoint = unLoadingPoint;
		this.productType = productType;
		this.truckType = truckType;
		this.noOfTruck = noOfTruck;
		this.weight = weight;
		this.dateOfBooking = dateOfBooking;
		this.comments = comments;
	}
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoadingPoint() {
		return loadingPoint;
	}

	public void setLoadingPoint(String loadingPoint) {
		this.loadingPoint = loadingPoint;
	}

	public String getUnLoadingPoint() {
		return unLoadingPoint;
	}

	public void setUnLoadingPoint(String unLoadingPoint) {
		this.unLoadingPoint = unLoadingPoint;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getTruckType() {
		return truckType;
	}

	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}

	public int getNoOfTruck() {
		return noOfTruck;
	}

	public void setNoOfTruck(int noOfTruck) {
		this.noOfTruck = noOfTruck;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Date getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public UUID getShipperId() {
		return shipperId;
	}

	public void setShipperId(UUID shipperId) {
		this.shipperId = shipperId;
	}

	@Override
	public String toString() {
		return "Load [id=" + id + ", loadingPoint=" + loadingPoint + ", unLoadingPoint=" + unLoadingPoint
				+ ", productType=" + productType + ", truckType=" + truckType + ", noOfTruck=" + noOfTruck + ", weight="
				+ weight + ", dateOfBooking=" + dateOfBooking + ", comments=" + comments + "]";
	}


  
}
