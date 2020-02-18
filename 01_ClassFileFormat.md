# JVM

## 1：JVM基础知识

1. 什么是JVM
    java virtual machine, 
    java虚拟机是一种规范，虚构出来的一台计算机
        -字节码指令集（汇编语言）
        -内存管理，堆栈方法区
2. 常见的JVM
    -hotspot
    -taobaoVM
## 2：ClassFileFormat
    (一个字节八位，一个十六进制数占了4位，也就是两个十六进制数是八位，即一个字节)
                  一个八进制数占了3位，
-是一个二进制字节流
-数据类型 u1(1个字节) u2(2个字节) u4（4个字节） u8（8个字节） 和_info(表类型)
    - _info的来源是Hotspot源码中的写法
-查看十六进制格式的class file
    - sublime/notpadd++
    - idea 插件BinEd
-有很多可以观察ByteCode的方法
    - javap
    - JBE 可以直接修改
    - idea插件 jclasslib
-classFile 构成
    -classFile{
        u4 magic CAFEBAbE 魔数
        u2 minor_version  jdk的小版本
        u2 major_version  jdk的大版本 1.7/1.8
        u2 constant_pool_count 常量池里面东西的数量 
        constant_pool 长度为constant_pool_count - 1的表
        access_flags  修饰符
        this_class    当前这个类的名字
        super_class   父类的名字
        interfaces_count    实现的接口数
        interfaces          具体实现了哪些接口
        fields_count        有多少个属性
        fields              具体是哪些属性
        methods_count       有多少个方法
        methods             方法的具体信息
        attributes_count    有多少其他附加属性的
        attributes          具体的其他的附加属性
    -}
    

## 3：类编译-加载-初始化

hashcode
锁的信息（2位 四种组合）
GC信息（年龄）
如果是数组，数组的长度

## 4：JMM

new Cat()
pointer -> Cat.class
寻找方法的信息

## 5：对象

1：句柄池 （指针池）间接指针，节省内存
2：直接指针，访问速度快

## 6：GC基础知识

栈上分配
TLAB（Thread Local Allocation Buffer）
Old
Eden
老不死 - > Old

## 7：GC常用垃圾回收器

new Object()
markword          8个字节
类型指针           8个字节
实例变量           0
补齐                  0		
16字节（压缩 非压缩）
Object o
8个字节 
JVM参数指定压缩或非压缩

