package com.huzheng.company;

public class Test1 {
}
class Hero4{
    public String name;
    protected float hp;
    public void attackHero(Hero4 h) throws EnemyHeroIsDeadException{
        if(hp==0){
            throw new EnemyHeroIsDeadException(h.name+"已经挂了，不需要发出技能");

        }
    }
    public String toString(){
        return name;
    }
    class EnemyHeroIsDeadException extends Exception{
        public EnemyHeroIsDeadException(){
        }
        public EnemyHeroIsDeadException(String msg){
            super(msg);
        }
    }

    public static void main(String[] args) {
        Hero4 garen = new Hero4();
        garen.name = "盖伦";
        garen.hp = 616;
        Hero4 teemo = new Hero4();
        teemo.name = "提莫";
        teemo.hp = 0;
        try{
            garen.attackHero(teemo);
        }
        catch (EnemyHeroIsDeadException e){
            System.out.println("异常的具体原因："+e.getMessage());
            e.printStackTrace();
        }
    }
}

