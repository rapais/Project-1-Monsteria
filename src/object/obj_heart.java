package object;

import Entity.Entity;
import Main.GamePanel;

public class obj_heart extends Entity{


	
	public obj_heart(GamePanel gp) {
		
		super(gp);
		
		name = "heart";
		image = setup("/objects/heart_full");
		image2 = setup("/objects/heart_half");
		image3 = setup("/objects/heart_blank");
		
		
		
	}
	
}
