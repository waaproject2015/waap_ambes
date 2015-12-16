
package mum.edu.controller;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import mum.edu.model.CarModel;
import mum.edu.model.Category;
import mum.edu.model.IcreateObjects;
import mum.edu.model.Sellers;
import mum.edu.model.SizeConstants;
@Named
@SessionScoped
public class PostBean implements Serializable{    
    private String category;
    private String itemName="Section:";
    private String author;
    private String makeup;
    private String size;
    private double price;
    private String photoName; 
    private String selectedCategory;
    private String selectedSize;
     private String selectedModel;
    private String label="Size:";
    private List<String> categories=Category.retrieveCategoryNames();   
    private List<String> sizeOrModel=SizeConstants.retrieveSize();//default will be size data
    private IcreateObjects seller=new Sellers();
    private boolean renderSize=true;
    private boolean authorOn=false;
    private String summaryColumn1;
    private String summaryColumn2;
    private String summaryColumn3;
    private String summaryColumn4;
    private List<String[]> postedProduct=new ArrayList();
    public String processPost(){  
        
        //*****************THis will post the data to collection and redirect the user to summary page
       if(selectedCategory.equals("cloth") ||selectedCategory.equals("car")){
        setRenderSize(true);
        if(label.equals("Makeup:")){
            summaryColumn1="Category"; summaryColumn2="Make"; summaryColumn3="Model"; summaryColumn4="Price";
        seller.createCar(selectedModel,itemName,price);
                getPostedProduct().add(new String[]{selectedCategory,selectedModel,itemName,""+price});              
        }   
        if(label.equals("Size:")){
            summaryColumn1="Category"; summaryColumn2="Size"; summaryColumn3="Section"; summaryColumn4="Price"; 
        seller.createCloth(selectedSize,itemName,price);
                getPostedProduct().add(new String[]{selectedCategory,selectedSize,itemName,""+price});
        }
         if(label.equals("Title:")){
              summaryColumn1="Category"; summaryColumn2="Title"; summaryColumn3="Author"; summaryColumn4="Price";
        seller.createCloth(selectedSize,itemName,price);
                getPostedProduct().add(new String[]{selectedCategory,itemName,author,""+price});
        }
       }
        return "postSummary?faces-redirect=true";
    }
    public void isCloth(AjaxBehaviorEvent e){
        if(selectedCategory.equals("cloth")){
            label="Size:";
            itemName="Section:";
            sizeOrModel=SizeConstants.retrieveSize();
            setRenderSize(true);
            setAuthorOn(false);
        }
        else if(selectedCategory.equals("car")){
            label="Makeup:";
            itemName="Model:";
            sizeOrModel=CarModel.retrieveModel();
            setRenderSize(true);
            setAuthorOn(false);
        }
        else if(selectedCategory.equals("book")){
            setRenderSize(false);
            label="Title:";
            itemName="Author:";
            setAuthorOn(true);
        }
    }
    
    //Getters and Setter
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public String getPhotoName() {
        return photoName;
    }   

    public void setCategory(String category) {
        this.category = category;
    }  
           

    /**
     * @return the categories
     */
    public List<String> getCategories() {
        return categories;
    }

    /**
     * @param categories the categories to set
     */
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @return the selectedCategory
     */
    public String getSelectedCategory() {
        return selectedCategory;
    }

    /**
     * @param selectedCategory the selectedCategory to set
     */
    public void setSelectedCategory(String selectedCategory) {
        this.selectedCategory = selectedCategory;
    }

    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return the selectedSize
     */
    public String getSelectedSize() {
        return selectedSize;
    }

    /**
     * @param selectedSize the selectedSize to set
     */
    public void setSelectedSize(String selectedSize) {
        this.selectedSize = selectedSize;
    }

    /**
     * @return the sizeConstants
     */
    public List<String> getSizeOrModel() {
        return sizeOrModel;
    }

    /**
     * @param sizeConstants the sizeConstants to set
     */
    public void setSizeOrModel(List<String> sizeOrModel) {
        this.sizeOrModel = sizeOrModel;
    }

    /**
     * @return the renderSize
     */
    public boolean isRenderSize() {
        return renderSize;
    }

    /**
     * @param renderSize the renderSize to set
     */
    public void setRenderSize(boolean renderSize) {
        this.renderSize = renderSize;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the makeup
     */
    public String getMakeup() {
        return makeup;
    }

    /**
     * @param makeup the makeup to set
     */
    public void setMakeup(String makeup) {
        this.makeup = makeup;
    }

    /**
     * @return the authorOn
     */
    public boolean isAuthorOn() {
        return authorOn;
    }

    /**
     * @param authorOn the authorOn to set
     */
    public void setAuthorOn(boolean authorOn) {
        this.authorOn = authorOn;
    }

    /**
     * @return the postedProduct
     */
    public List<String[]> getPostedProduct() {
        return postedProduct;
    }

    /**
     * @param postedProduct the postedProduct to set
     */
    public void setPostedProduct(List<String[]> postedProduct) {
        this.postedProduct = postedProduct;
    }

    /**
     * @return the summaryColumn1
     */
    public String getSummaryColumn1() {
        return summaryColumn1;
    }

    /**
     * @param summaryColumn1 the summaryColumn1 to set
     */
    public void setSummaryColumn1(String summaryColumn1) {
        this.summaryColumn1 = summaryColumn1;
    }

    /**
     * @return the summaryColumn2
     */
    public String getSummaryColumn2() {
        return summaryColumn2;
    }

    /**
     * @return the summaryColumn3
     */
    public String getSummaryColumn3() {
        return summaryColumn3;
    }

    /**
     * @param summaryColumn3 the summaryColumn3 to set
     */
    public void setSummaryColumn3(String summaryColumn3) {
        this.summaryColumn3 = summaryColumn3;
    }

    /**
     * @return the summaryColumn4
     */
    public String getSummaryColumn4() {
        return summaryColumn4;
    }

    /**
     * @param summaryColumn4 the summaryColumn4 to set
     */
    public void setSummaryColumn4(String summaryColumn4) {
        this.summaryColumn4 = summaryColumn4;
    }
    
    }