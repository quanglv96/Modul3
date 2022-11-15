use quanlysinhvien;
select * from student;
select * from student 
where status=true;
select * from subject;
select * from subject
where credit<10;
select S.StudentID, S.StudentName,C.ClassName
from student S join class C on S.ClassID=C.ClassID;
select S.StudentID, S.StudentName,C.ClassName
from Student S join Class C on S.ClassID=C.ClassID
where C.ClassName='A1';
select S.StudentID, S.StudentName,Sub.SubName,M.Mark
From Student S join Mark M on S.StudentID=M.StudentID join subject Sub on M.SubId=Sub.SubId;
select S.StudentID, S.StudentName,Sub.SubName,M.Mark
From Student S join Mark M on S.StudentID=M.StudentID join subject Sub on M.SubId=Sub.SubId
where Sub.SubName='CF';