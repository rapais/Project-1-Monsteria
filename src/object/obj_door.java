package object;

import Entity.Entity;
import Main.GamePanel;

public class obj_door extends Entity{
	

public obj_door(GamePanel gp) {
	
		super(gp);
		
		name = "door";
		down1 = setup("/objects/door");
		collision = true;
		
		solidArea.x = 0;
		solidArea.y = 16;
		solidArea.width = 48;
		solidArea.height = 32;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
	}
}
