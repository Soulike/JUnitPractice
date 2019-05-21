public class Course
{
    private String name;    // 课程名
    private int numStudents = 0;
    private boolean hasProcessor = false;

    public Course(String name)
    {
        this.name = name;
    }

    public void addStudent()
    {
        if (this.numStudents < 10)
        {
            this.numStudents++;
        }
    }

    public void removeStudent()
    {
        if (this.numStudents > 0)
        {
            this.numStudents--;
        }
    }

    public void addProcessor()
    {
        this.hasProcessor = true;
    }

    public void removeProcessor()
    {
        this.hasProcessor = false;
    }

    public void close()
    {
        if (this.hasProcessor)
        {
            if (this.numStudents < 3)
            {
                this.cancel();
            }
            else    // this.numStudents >= 3
            {
                this.commit();
            }
        }
        else    // !this.hasProcessor
        {
            this.cancel();
        }
    }

    public void closeRegistration()
    {
        if (this.hasProcessor)
        {
            if (this.numStudents >= 3)
            {
                this.commit();
            }
        }
        else    // !this.hasProcessor
        {
            this.cancel();
        }
    }

    private void cancel()
    {
        System.out.println("Course " + this.name + " canceled");
    }

    private void commit()
    {
        System.out.println("Course " + this.name + " committed with " + this.numStudents + "students");
    }
}
