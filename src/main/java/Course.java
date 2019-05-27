public class Course
{
    private String name;    // 课程名
    private int numStudents = 0;

    private boolean hasProcessor = false;
    private boolean isCanceled = false;
    private boolean isCommitted = false;

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

    public boolean isAssigned()
    {
        return this.hasProcessor;
    }

    public boolean isCanceled()
    {
        return this.isCanceled;
    }

    public boolean isCommitted()
    {
        return this.isCommitted;
    }

    public boolean isFull()
    {
        return this.numStudents == 10;
    }

    public void cancel()
    {
        this.isCanceled = true;
        System.out.println("Course " + this.name + " was canceled");
    }

    private void commit()
    {
        this.isCommitted = true;
        System.out.println("Course " + this.name + " was committed with " + this.numStudents + " students");
    }


}
