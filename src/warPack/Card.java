package warPack;

import java.awt.Image;

import javax.swing.ImageIcon;

class Card {
    String suit;
    int value;
    int cardx;
    int cardy;
    int scale;
 
    public Card(int value, String suit) {
        this.suit = suit;
        this.value = value;
        this.scale = 5; // image scalar
        this.cardx = 500 / this.scale;
        this.cardy = 726 / this.scale;
    }
 
    public String toString() {
        return value + " of " + suit;
    }
    
    public ImageIcon getImg() {
    	String img_path = "img\\";
    	boolean add_two = true;

    	if(this.value == 11) {
    		img_path += "jack";
    	}else if(this.value == 12) {
    		img_path += "queen";
    	}else if(this.value == 13) {
    		img_path += "king";
    	}else if(this.value == 1) {
    		img_path += "ace";
    		add_two = false;
    	}else {
    		add_two = false;
    		img_path += this.value;
    	}
    	img_path += "_of_" + this.suit.toLowerCase();
    	
    	if(add_two) {
    		img_path += "2";
    	}
    	
    	return new ImageIcon(
    			new ImageIcon(img_path + ".png")
    			.getImage()
    			.getScaledInstance(this.cardx, this.cardy, Image.SCALE_DEFAULT)
    			);
    }
    
}