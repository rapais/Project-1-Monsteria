package Main;

import Entity.NPC_Void;
import monster.mons_GreenSlime;
import object.obj_door;


public class AssetSetter {
	
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {

		
	}
	
	public void setNPC() {
		
		gp.npc[0] = new NPC_Void(gp);
		gp.npc[0].worldX = gp.tileSize*21;
		gp.npc[0].worldY = gp.tileSize*21;
		

	}
	
	public void setMonster() {
		
		gp.monster[0] = new mons_GreenSlime(gp);
		gp.monster[0].worldX = gp.tileSize*23;
		gp.monster[0].worldY = gp.tileSize*36;
		
		gp.monster[1] = new mons_GreenSlime(gp);
		gp.monster[1].worldX = gp.tileSize*23;
		gp.monster[1].worldY = gp.tileSize*37;
		
	}

}
