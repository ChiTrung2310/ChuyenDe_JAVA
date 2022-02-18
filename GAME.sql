
--Tạo CSDL GAME để lưu thông tin người chơi và kết quả
create database GAME

use GAME
go

--Tạo table Users
create table USERS(
	UserID varchar(20) primary key,
	Name nvarchar(50) unique,
	DIEM char(4),
	RoleLevel int check (RoleLevel in(0,1,2))	
)
go

--Tạo table Lịch sử game (lưu điểm và thời gian của người chơi)
create table LICHSUGAME(
	STT int identity primary key,
	Thoi_Diem datetime default GETDATE(),
	DIEM char(4),
	Thoi_Gian int,
	Ket_Qua nvarchar(50),
	UserID varchar(20) foreign key (UserID) references USERS(UserID)
)
go


--Tạo thủ tục kiểm tra và cho phép người chơi đăng ký tài khoản để chơi game
create proc ThemUser(@userid varchar(20), @name varchar(50), @pass varchar(50), @rolelevel int, @kq nvarchar(300) output)
as

set @kq = ''

if exists (select * from USERS where UserID = @userid)
	set @kq = N'User Đã có' + char(10) 

if exists (select * from USERS where Name = @name)
	set @kq += N'Trùng tên' + char(10) 

if @rolelevel not in (0,1,2)
	set @kq += N'Quyền phải là: 0,1,2'

if @kq =''
begin 
	insert into USERS values (@userid, @name, @pass, @rolelevel)
	set @kq = N'Đã đăng ký tài khoản mới thành công'
end
go



--Tạo thủ tục kiểm tra và cho phép người chơi ghi lịch sử chơi game của mình vào database
alter proc ThemLichSu(@diem char(4), @thoigian int, @ketqua nvarchar(50), @userid varchar(20), @kq nvarchar(300) output)
as

set @kq = ''

if @diem < 0
	set @kq = N'Điểm phải >= 0' + char(10) 

if @thoigian < 0
	set @kq += N'Thời gian chơi phải >=0' + char(10) 

if not exists (select * from USERS where UserID = @userid)
	set @kq += N'UserID không hợp lệ' + char(10) 


if @kq =''
begin 
	insert into LICHSUGAME(DIEM, Thoi_Gian, Ket_Qua, UserID) values (@diem, @thoigian, @ketqua, @userid)
	set @kq = N'Đã ghi lịch sử người chơi'
end
go
