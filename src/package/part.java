abstract class  Part{
    double baseprice;
    double pricepolicy;
    abstract double getprice();
}
abstract class Pricepolicy{
    double discount;
    abstract double getDiscount();
}
class PartPolicy extends Pricepolicy{
    @Override
    double getDiscount() {
        return discount;
    }
    PartPolicy(double discount)
    {
        this.discount=discount;
    }
    }
    


//为此我们引入了类PricePolicy，
//与类Part呈关联关系，这样做的好处是
//零件对象与价格策略对象的对应是动态的，
//往往你认为的复杂，其实是最佳实现，你认为的简单，其实是软件灾难的开始
class Memory extends Part{
    @Override
    double getprice() {
        return baseprice;
    }
    Memory(double baseprice,double pricepolicy)
    {
        this.baseprice=baseprice;this.pricepolicy=pricepolicy;
    }
}
class Motherboard extends Part{
    @Override
    double getprice() {
      return baseprice+pricepolicy;
    }
    Motherboard(double baseprice,double pricepolicy)
    {
        this.baseprice=baseprice;this.pricepolicy=pricepolicy;
    }
    
}
class Cpu extends Part{
    PartPolicy partPolicy;
    @Override
    double getprice() {
        return baseprice*partPolicy.getDiscount();
    }
    Cpu(double baseprice,double pricepolicy)
    {
        this.baseprice=baseprice;this.pricepolicy=pricepolicy;
    }
    Cpu(double baseprice,PartPolicy pricepolicy)
    {
        this.baseprice=baseprice;this.partPolicy=pricepolicy;
    }
    
}
class MMain{
    public static void main(String[] args) {
        Memory memory=new Memory(12,13);
        PartPolicy memp=new PartPolicy(98.0);

        
        Motherboard motherboard=new Motherboard(13,16);

        PartPolicy cpup=new PartPolicy(0.99);
        Cpu cpu=new Cpu(100,cpup);
        System.out.println(cpu.getprice());
        Part[] parts=new Part[2];
        parts[0]=memory;
        parts[1]=motherboard;
        //parts[2]=cpu;
        System.out.println(totalprice(parts));
        memp.equals(memp);////////////////////////////////////////////////////////////////
    }
    static double totalprice(Part[] parts){
        double total=0.0;
        for (Part item:parts){
            // if (item instanceof Memory)
            //   total+=1.45*item.getprice();
            // else if (item instanceof Motherboard)
            //   total+=1.3*item.getprice();
            // else
              total+=item.getprice();    
        }
        return total;
        
    }
}
