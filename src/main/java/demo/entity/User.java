package demo.entity;

import java.util.List;

/**
 * @author: GMH
 * @create: 2020-02-07
 * @Description：
 * @Modified By：
 * @Version: 1.0.0
 */
public class User {
    private int id;
    private String name;
    private int sex;
    private List ids;

    public List getIds() {
        return ids;
    }

    public void setIds(List ids) {
        this.ids = ids;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
