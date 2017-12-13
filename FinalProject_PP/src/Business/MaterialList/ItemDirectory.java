/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.MaterialList;

import Business.MaterialList.Item.Type;
import java.util.ArrayList;

/**
 *
 * @author jiahuanli
 */
public class ItemDirectory {
    
    private ArrayList<Item> itemList;

    public ItemDirectory() {
        itemList = new ArrayList<>();
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public Item createItem(String name,Type type, double price){
        Item item = null;
        if (type.getValue().equals(Type.Inventory.getValue())){
            item = new InventoryItem();
        }else if (type.getValue().equals(Type.Request.getValue())){
            item = new RequestItem();
        }
        
        item.setName(name);
        item.setPrice(price);
        itemList.add(item);
        return item;
    }
    
}
