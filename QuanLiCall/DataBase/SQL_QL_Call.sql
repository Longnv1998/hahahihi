create database Manager_conversation
go

use Manager_conversation
go
--table--
create table tbl_Admin(MaAd int identity primary key, HoVaTen nvarchar(100) not null, TenTK varchar(50) unique not null, MatKhau varchar(50) not null, Mota nvarchar(250))
go
create table tbl_NguoiGoi(MaGoi varchar(50) primary key, HoVaTen nvarchar(100) not null, Mota nvarchar(100) not null)
go
create table tbl_NguoiNhan(MaNhan varchar(50) primary key, HoVaTen nvarchar(100) not null, Mota nvarchar(100) not null)
go
create table tbl_User(MaUser int identity primary key, HoVaTen nvarchar(100) not null, TenTK varchar(50) unique not null, MatKhau nvarchar(50) not null,GioiTinh bit not null,Tuoi int not null, DiaChi nvarchar(250) not null,SDT varchar(50) not null, 
	MaGoi varchar(50) foreign key references tbl_NguoiGoi(MaGoi),
	MaNhan varchar(50) foreign key references tbl_NguoiNhan(MaNhan)
)
go
create table tbl_conversation(MaConversation int identity primary key,ChiTiet nvarchar(250) not null, HoatDong bit,
	MaGoi varchar(50) foreign key references tbl_NguoiGoi(MaGoi),
	MaNhan varchar(50) foreign key references tbl_NguoiNhan(MaNhan)
)
go
create table tbl_BaoCao(
	MaBaoCao int identity primary key,
	TenBaoCao nvarchar(100) not null, 
	SLKH int,
	SLConversation int, 
	Mota nvarchar(250))
go
--insert--
insert into tbl_Admin values(N'Long','admin','admin',N'admin')
--Proc--
create proc login
	@TenTK varchar(50),
	@MatKhau varchar(50)
as
select*from tbl_Admin a where TenTK=@TenTK and MatKhau=@MatKhau
go

create proc insert_NguoiDung
	@HoVaTen nvarchar(100),
	@TenTK varchar(50),
	@MatKhau nvarchar(50),
	@GioiTinh bit,
	@Tuoi int,
	@DiaChi nvarchar(250),
	@SDT varchar(50)
as
insert into  tbl_User(HoVaTen,TenTK,MatKhau,GioiTinh,Tuoi,DiaChi,SDT) values(@HoVaTen,@TenTK,@MatKhau,@GioiTinh,@Tuoi,@DiaChi,@SDT)