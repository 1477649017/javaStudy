
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class WarehouseManagementSystem{
    public static void main(String[] args){
        ArrayList<Warehouse> warehouseList=new ArrayList<Warehouse>();
        ArrayList<Goods> goodsList=new ArrayList<Goods>();
        File file1 = new File("D:/Info/Goods.txt");
        File file2 = new File("D:/Info/Warehouse.txt");
        int choice=-1;
        Scanner sc=new Scanner(System.in);
        while(choice!=0){
            System.out.println("*************************");
            System.out.println("1、添加仓库");
            System.out.println("2、修改仓库");
            System.out.println("3、删除仓库");
            System.out.println("4、添加产品");
            System.out.println("5、修改产品");
            System.out.println("6、删除产品");
            System.out.println("7、显示仓库");
            System.out.println("8、显示产品");
            System.out.println("9、查询数量");
            System.out.println("10、初始化仓库,产品信息");
            System.out.println("0、退出");
            System.out.print("请输入您的选择：");
            choice=sc.nextInt();
            switch(choice){
                case 1:
                    //添加仓库
                    System.out.print("请输入仓库编号：");
                    int number=sc.nextInt();
                    System.out.print("请输入仓库名称：");
                    String name=sc.next();
                    System.out.print("请输入仓库容量：");
                    int capacity=sc.nextInt();
                    Warehouse warehouse=new Warehouse(number,name,capacity);
                    warehouseList.add(warehouse);
                    System.out.println("添加成功！");
                    break;
                case 2:
                    //修改仓库
                    System.out.print("请输入要修改的仓库编号：");
                    int updateNumber=sc.nextInt();
                    for(int i=0;i<warehouseList.size();i++){
                        if(warehouseList.get(i).getNumber()==updateNumber){
                            System.out.print("请输入新的仓库名称：");
                            String updateName=sc.next();
                            System.out.print("请输入新的仓库容量：");
                            int updateCapacity=sc.nextInt();
                            Warehouse updateWarehouse=new Warehouse(updateNumber,updateName,updateCapacity);
                            warehouseList.set(i,updateWarehouse);
                            System.out.println("修改成功！");
                            break;
                        }
                    }
                    break;
                case 3:
                    //删除仓库
                    System.out.print("请输入要删除的仓库编号：");
                    int deleteNumber=sc.nextInt();
                    for(int i=0;i<warehouseList.size();i++){
                        if(warehouseList.get(i).getNumber()==deleteNumber){
                            warehouseList.remove(i);
                            System.out.println("删除成功！");
                            break;
                        }
                    }
                    break;
                case 4:
                    //添加产品
                    System.out.print("请输入产品编号：");
                    int goodsNumber=sc.nextInt();
                    System.out.print("请输入产品名称：");
                    String goodsName=sc.next();
                    System.out.print("请输入产品数量：");
                    int goodsAmount=sc.nextInt();
                    Goods goods=new Goods(goodsNumber,goodsName,goodsAmount);
                    goodsList.add(goods);
                    System.out.println("添加成功！");
                    break;
                case 5:
                    //修改产品
                    System.out.print("请输入要修改的产品编号：");
                    int updateGoodsNumber=sc.nextInt();
                    for(int i=0;i<goodsList.size();i++){
                        if(goodsList.get(i).getNumber()==updateGoodsNumber){
                            System.out.print("请输入新的产品名称：");
                            String updateGoodsName=sc.next();
                            System.out.print("请输入新的产品数量：");
                            int updateGoodsAmount=sc.nextInt();
                            Goods updateGoods=new Goods(updateGoodsNumber,updateGoodsName,updateGoodsAmount);
                            goodsList.set(i,updateGoods);
                            System.out.println("修改成功！");
                            break;
                        }
                    }
                    break;
                case 6:
                    //删除产品
                    System.out.print("请输入要删除的产品编号：");
                    int deleteGoodsNumber=sc.nextInt();
                    for(int i=0;i<goodsList.size();i++){
                        if(goodsList.get(i).getNumber()==deleteGoodsNumber){
                            goodsList.remove(i);
                            System.out.println("删除成功！");
                            break;
                        }
                    }
                    break;
                case 7:
                    //显示仓库
                    System.out.println("仓库编号\t仓库名称\t仓库容量");
                    for(int i=0;i<warehouseList.size();i++){
                        System.out.println(warehouseList.get(i).getNumber()+"\t\t"+warehouseList.get(i).getName()+"\t\t"+warehouseList.get(i).getCapacity());
                    }
                    break;
                case 8:
                    //显示产品
                    System.out.println("产品编号\t产品名称\t产品数量");
                    for(int i=0;i<goodsList.size();i++){
                        System.out.println(goodsList.get(i).getNumber()+"\t\t"+goodsList.get(i).getName()+"\t\t"+goodsList.get(i).getAmount());
                    }
                    break;
                case 9:
                    //查询数量
                    System.out.print("请输入要查询的产品编号：");
                    int searchNumber=sc.nextInt();
                    for(int i=0;i<goodsList.size();i++){
                        if(goodsList.get(i).getNumber()==searchNumber){
                            System.out.println("查询结果：");
                            System.out.println("产品名称："+goodsList.get(i).getName());
                            System.out.println("产品数量："+goodsList.get(i).getAmount());
                            break;
                        }
                    }
                    break;
                case 10:
                    //初始化仓库 产品信息
                    try(InputStream inputStream1 = new FileInputStream(file1);InputStream inputStream2 = new FileInputStream(file2)){
                        System.out.println("产品信息如下：");
                        Scanner scanner1 = new Scanner(inputStream1);
                        while (scanner1.hasNext()){
                            int GoodsNum = Integer.parseInt(scanner1.next());
                            String GoodsName = scanner1.next();
                            int GoodsAmount = Integer.parseInt(scanner1.next());
                            System.out.println("产品编号:" + GoodsNum + " 产品名:" + GoodsName + " 产品数量:" + GoodsAmount);
                        }

                        System.out.println("仓库信息如下：");
                        Scanner scanner2 = new Scanner(inputStream2);
                        while (scanner2.hasNext()){
                            int WareNum = Integer.parseInt(scanner2.next());
                            String WareName = scanner2.next();
                            int WareCapacity = Integer.parseInt(scanner2.next());
                            System.out.println("仓库编号:" + WareNum + " 仓库名:" + WareName + " 仓库容量:" + WareCapacity);
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 0:
                    //退出 并且将数据保存进入文件
                    try(OutputStream outputStream1 = new FileOutputStream(file1);OutputStream outputStream2 = new FileOutputStream(file2)) {
                        PrintWriter printWriter1 = new PrintWriter(outputStream1);
                        for (int i = 0;i < goodsList.size();i++){
                            int goodsNum = goodsList.get(i).getNumber();
                            String goodsNam = goodsList.get(i).getName();
                            int goodsAum = goodsList.get(i).getAmount();
                            printWriter1.println("" + goodsNum + " " + goodsNam + " " + goodsAum);
                            printWriter1.flush();//一定要刷新话缓冲区
                        }

                        PrintWriter printWriter2 = new PrintWriter(outputStream2);
                        for (int i = 0;i < warehouseList.size();i++){
                            int wareNum = warehouseList.get(i).getNumber();
                            String wareNam = warehouseList.get(i).getName();
                            int wareCapa = warehouseList.get(i).getCapacity();
                            printWriter2.println("" + wareNum + " " + wareNam + " " + wareCapa);
                            printWriter2.flush();
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    System.out.println("程序已退出！");
                    break;
            }
        }
    }
}