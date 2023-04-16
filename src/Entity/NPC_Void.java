package Entity;

import java.awt.Rectangle;
import java.util.Random;

import Main.GamePanel;

public class NPC_Void extends Entity{
	
	public final int screenX;
	public final int screenY;
	
	public NPC_Void(GamePanel gp) {
		super(gp);
		
		direction = "down";
		speed = 1;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		solidArea = new Rectangle();
		solidArea.x = 10;
		solidArea.y = 20;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 30;
		solidArea.height = 30;
		
		getImage();
		setDialogue();
	}
	
	public void getImage() {
		
		up1 = setup("/npc/npc_up_1");
		up2 = setup("/npc/npc_up_2");
		down1 = setup("/npc/npc_down_1");
		down2 = setup("/npc/npc_down_2");
		left1 = setup("/npc/npc_left_1");
		left2 = setup("/npc/npc_left_2");
		right1 = setup("/npc/npc_right_1");
		right2 = setup("/npc/npc_right_2");
		
	}
	
	public void setDialogue() {
		
		dialogues[0] = "Oi, lad";
		dialogues[1] = "What'ca doing in this island";
		dialogues[2] = "Don't tell me it's for the treasure..";
		dialogues[3] = "It's not too late to go back";
		dialogues[4] = "By the way, if u spam my chat again\nyou will Receive a full heal at the\npond above us";
		
	}
	
	public void setAction() {
		
		actionLockCounter ++;
		
		if(actionLockCounter == 120) {
			
			Random random = new Random();
			int i = random.nextInt(100)+1; //random number dari 1-100
			
			if(i <= 25) {
				direction = "up";
			}
			if(i >25 && i <= 50) {
				direction = "down";
			}
			if(i >50 && i <= 75) {
				direction = "left";
			}
			if(i >75 && i <= 100) {
				direction = "right";
			}
			
			actionLockCounter = 0;
			
		}
		
	}
	
	public void speak() {
		
		super.speak();
	}
	

}
