package object;

import Entity.Entity;
import Main.GamePanel;

public class obj_boots extends Entity{
	

public obj_boots(GamePanel gp) {
	
		super(gp);
		
		name = "boots";
		down1 = setup("/objects/boots");
		
	}
}
