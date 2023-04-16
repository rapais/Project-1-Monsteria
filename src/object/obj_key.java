package object;

import Entity.Entity;
import Main.GamePanel;

public class obj_key extends Entity{
	
	
	public obj_key(GamePanel gp) {
		super(gp);
		
		name = "key";
		down1 = setup("/objects/key");
			
		
	}

}
