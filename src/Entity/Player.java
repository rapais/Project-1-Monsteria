package Entity;


import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;
import Main.KeyHandler;
import Main.UtilityTool;

public class Player extends Entity {
	
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	int standCounter = 0;
	
	public Player(GamePanel gp, KeyHandler KeyH) {
		
		super(gp);
		
		this.keyH = KeyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		solidArea = new Rectangle();
		solidArea.x = 20;
		solidArea.y = 20;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 10;
		solidArea.height = 20;
		
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		
		worldX = gp.tileSize * 23;
		worldY = gp.tileSize * 21;
		speed = 4;
		direction = "down";
		
		maxLife = 6;
		life = maxLife;
	}
	
	public void getPlayerImage() {
		
		up1 = setup("/player/sprite_up_1");
		up2 = setup("/player/sprite_up_2");
		down1 = setup("/player/sprite_down_1");
		down2 = setup("/player/sprite_down_2");
		left1 = setup("/player/sprite_left_1");
		left2 = setup("/player/sprite_left_2");
		right1 = setup("/player/sprite_right_1");
		right2 = setup("/player/sprite_right_2");
		
		
	}
	
	public void update() {
		
		if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
			
			if(keyH.upPressed == true) {
				direction = "up";		
			}
			else if (keyH.downPressed == true) {
				direction = "down";			
			}
			else if (keyH.leftPressed == true) {
				direction = "left";			
			}
			else if (keyH.rightPressed == true) {
				direction = "right";			
			}
			
			// cek collision
			collisionOn = false;
			gp.checker.checkTile(this);
			
			//cek collision object
			int objIndex = gp.checker.checkObject(this,true);
			pickUpObject(objIndex);
			
			//cek collision npc
			int npcIndex = gp.checker.checkEntity(this, gp.npc);
			interactNPC(npcIndex);
			
			//cek monster coliision
			int monsterIndex = gp.checker.checkEntity(this, gp.monster);
			
			//cek event
			gp.eHandler.checkEvent();
			
			gp.keyH.EPressed = false;
			
			
			//cek kebenaran collision
			if(collisionOn == false) {
				
				switch(direction) {
				case "up":
					worldY -= speed;
					break;
				case "down":
					worldY += speed;
					break;
				case "left":
					worldX -= speed;
					break;
				case "right":
					worldX += speed;
					break;
				}
			}
			
			spriteCounter++;
			if(spriteCounter > 12) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}
				else if(spriteNum == 2) {
					spriteNum =1;
				}
				spriteCounter = 0;
			}
			
		}
		
	}
	
	public void pickUpObject(int i) {
		if(i != 999){
			
		}
	}
	
	public void interactNPC(int i) {
		
		if(i != 999){
			
			if(gp.keyH.EPressed == true) {
				gp.gameState = gp.dialogueState;
				gp.npc[i].speak();
			}
			
		}
		
	}
	
	public void draw(Graphics2D g2) {
		
//		g2.setColor(Color.white);
//		
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			break;
		case "down":
			if(spriteNum == 1) {
				image = down1;
			}
			if(spriteNum == 2) {
				image = down2;
			}
			break;
		case "left":
			if(spriteNum == 1) {
				image = left1;
			}
			if(spriteNum == 2) {
				image = left2;
			}
			break;
		case "right":
			if(spriteNum == 1) {
				image = right1;
			}
			if(spriteNum == 2) {
				image = right2;
			}
			break;
		}
		
		g2.drawImage(image, screenX, screenY, null);
		
	}

}













