class Person{
    //默认为public
    private var age = 0  //必须赋值
    def increment(){ age +=1 }
    def current = age    //无参数方法可省略()
}
class Student{
    //对象私有字段
    private[this] var privateage = 0   //仅限student使用，子对象不能使用
    val name = "gpl"
    def age = privateage
    def isYounger(other:Student) = privateage < other.age
}
class Teacher{
    var name:String = _
    private var age = 27
    private[this] val gender = "male"
    //构造器
    def this(name:String){
        this()     //必须调用默认构造器
        this.name = name
    }
    def sayHello(): Unit ={
        println(this.name+":"+this.age+":"+this.gender)
    }
}

class Teacher1(val name:String,val age:Int){  //主构造器
    println("This is primary constructor!")
    var gender:String  = _
    println("主"+gender)

    def this(name:String,age:Int,gender:String){

        this(name,age)   //必须调用主构造器
        this.gender = gender
        println("this")
    }
    def getName = name
    def getAge = age
    def getGender = gender
}
object learn{
    def main(args:Array[String]): Unit ={
//        val person = new Person()
//        person.increment()
//        println(person.current)
//
//        val student = new Student
//        println(student.name)
//        println(student.age)
//
//        val teacher = new Teacher("gplyl")
//        //teacher.name = "gpl"
//        teacher.sayHello()

        val teacher1 =new Teacher1("gplyl",22,"male") //重载构造器
        //val teacher1 =new Teacher1("gplyl",22) //默认构造器
        println(teacher1.getName)
        println(teacher1.getAge)
        println(teacher1.getGender)

    }


}