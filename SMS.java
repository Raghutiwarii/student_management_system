import java.util.*;
import java.io.*;

class MainMenu
{
  public void menu()
  {
    System.out.println("\t\t*******************************************");
    System.out.println("\t\t\t  STUDENT MANAGEMENT SYSTEM");
    System.out.println("\t\t*******************************************");
    System.out.println("\t\t\t    --------------------");
    System.out.println("\t\t\t     ~$ Raghunath Tiwari");
    System.out.println("\t\t\t    --------------------");
    System.out.println("\n\nPress 1 : To Add an student Details");
    System.out.println("Press 2 : To See an student Details ");
    System.out.println("Press 3 : To Remove an student");
    System.out.println("Press 4 : To Update student Details");
    System.out.println("Press 5 : To Exit the EMS Portal");

  }
}

/************************ To add details of student *********************/

class Student_Add
{
    public void createFile()
    {
        Scanner sc = new Scanner(System.in);

        StudentDetail emp =new StudentDetail();
        emp.getInfo();
        try{
            File f1=new File("file"+emp.student_id+".txt");
            if(f1.createNewFile()){
                FileWriter myWriter = new FileWriter("file"+emp.student_id+".txt");
                myWriter.write("student ID:"+emp.student_id+"\n"+"student Name     :"+emp.name+"\n"+
                "Father's Name     :"+emp.father_name+"\n"+"student Contact  :"+emp.student_contact+"\n"+
                "Email Information :"+emp.email+"\n"+"student position :"+emp.position+"\n"+
                "student Salary   :"+emp.student_salary);
                myWriter.close();
                System.out.println("\nstudent has been Added :)\n");

                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
            }
            else {
                System.out.println("\nstudent already exists :(");
                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
            }
        }
        catch(Exception e){System.out.println(e);}
    }
}

/************************* Taking student Details ************************/

class StudentDetail
{
    String name;
    String father_name;
    String email;
    String position;
    String student_id;
    String student_salary;
    String student_contact;
    public void getInfo()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter student's name --------: ");
        name=sc.nextLine();
        System.out.print("Enter student's Father name -: ");
        father_name=sc.nextLine();
        System.out.print("Enter student's ID ----------: ");
        student_id=sc.nextLine();
        System.out.print("Enter student's Email ID ----: ");
        email=sc.nextLine();
        System.out.print("Enter student's Position ----: ");
        position=sc.nextLine();
        System.out.print("Enter student contact Info --: ");
        student_contact=sc.nextLine();
        System.out.print("Enter student's Salary ------: ");
        student_salary=sc.nextLine();
    }
}

/************************ To Show details of student *********************/

class student_Show
{
  public void viewFile(String s) throws Exception
  {
    File file = new File("file"+s+".txt");
    Scanner sc = new Scanner(file);

    while (sc.hasNextLine())
     {
       System.out.println(sc.nextLine());
     }
   }
}

/***************************** To Remove student *************************/

class student_Remove
{
    public void removeFile(String ID)
    {

    File file = new File("file"+ID+".txt");
      if(file.exists())
       {
         if(file.delete());
         {
           System.out.println("\nstudent has been removed Successfully");
         }
       }
      else
       {
            System.out.println("\nstudent does not exists :( ");
       }
     }
}

/************************ To Update details of student ********************/

class student_Update
{
  public void updateFile(String s,String o,String n) throws IOException
  {
   File file = new File("file"+s+".txt");
   Scanner sc = new Scanner(file);
   String fileContext="";
   while (sc.hasNextLine())
       {
         fileContext =fileContext+"\n"+sc.nextLine();
       }
   FileWriter myWriter = new FileWriter("file"+s+".txt");
   fileContext = fileContext.replaceAll(o,n);
   myWriter.write(fileContext);
   myWriter.close();

  }
}


/************************ To Exit from the EMS Portal *********************/

class CodeExit
{
  public void out()
  {
    System.out.println("\n*****************************************");
    System.out.println("\t\t\t$  Thank You For Using my Software :) ");
    System.out.println("*****************************************");
    System.out.println("\t\t\t/~ <0d3d by Raghunath Tiwari\n");
    System.exit(0);
  }
}


/***************************** Main Class *******************************/
class studentManagementSystem
{
  public static void main(String arv[])
  {
    /** To clear the output Screen **/
    System.out.print("\033[H\033[2J");

    Scanner sc = new Scanner(System.in);
    student_Show epv = new student_Show();

    int i=0;

    /*** Callining Mainmenu Class function ****/
    MainMenu obj1 = new MainMenu();
    obj1.menu();

    /*** Initialising loop for Menu Choices ***/
    do{

      System.out.print("\nPlease Enter choice :");
      i=Integer.parseInt(sc.nextLine());

      /** Switch Case Statements **/
      switch(i)
      {
        case 1:
        {
        /** Creating class's object and calling Function using that object **/
        Student_Add ep =new Student_Add();
        ep.createFile();

        System.out.print("\033[H\033[2J");
        obj1.menu();
        break;
        }
        case 2:
        {
          System.out.print("\nPlease Enter student's ID :");
          String s=sc.nextLine();
          try
          {
            epv.viewFile(s);}
            catch(Exception e){System.out.println(e);}


            System.out.print("\nPress Enter to Continue...");
            sc.nextLine();
            System.out.print("\033[H\033[2J");
            obj1.menu();
            break;
          }

        case 3:
        {
          System.out.print("\nPlease Enter student's ID :");
          String s=sc.nextLine();
          student_Remove epr =new student_Remove();
          epr.removeFile(s);

          System.out.print("\nPress Enter to Continue...");
          sc.nextLine();
          System.out.print("\033[H\033[2J");
          obj1.menu();
          break;
        }
        case 4:
        {
            System.out.print("\nPlease Enter student's ID :");
            String I=sc.nextLine();
            try
            {
              epv.viewFile(I);
            }
            catch(Exception e)
            {
              System.out.println(e);
            }
            student_Update epu = new student_Update();
            System.out.print("Please Enter the detail you want to Update :");
    	      System.out.print("\nFor Example :\n");
            System.out.println("If you want to Change the Name, then Enter Current Name and Press Enter. Then write the new Name then Press Enter. It will Update the Name.\n");
            String s=sc.nextLine();
            System.out.print("Please Enter the Updated Info :");
            String n=sc.nextLine();
            try
            {
              epu.updateFile(I,s,n);

              System.out.print("\nPress Enter to Continue...");
              sc.nextLine();
              System.out.print("\033[H\033[2J");
              obj1.menu();
              break;
            }
            catch(IOException e)
            {
              System.out.println(e);
            }
        }
        case 5:
        {
          CodeExit obj = new CodeExit();
          obj.out();
        }
      }
    }while(i<6);

    
  }
}
