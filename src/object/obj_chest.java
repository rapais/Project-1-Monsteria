package object;

import Entity.Entity;
import Main.GamePanel;

public class obj_chest extends Entity{
	

public obj_chest(GamePanel gp) {
	
		super(gp);
		
		name = "chest";
		down1 = setup("/objects/chest");
	}
}
