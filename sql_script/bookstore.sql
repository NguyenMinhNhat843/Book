use master 

go
if exists (select * from sysdatabases where name='BookStore')
	drop database BookStore
go

create database BookStore 
on primary (
	name=BookStore_Data,
	filename='D:\BookStore.mdf'
)
log on (
	name=BookStore_Log,
	filename='D:\BookStore.ldf'
)
go

---------------------- create tabels ---------------------
use BookStore
go

-- table rank --
create table Rank (
	maRank nvarchar(10) primary key not null,
	tenRank nvarchar(10),
	tiLeTichDiem float
)

-- tabel KhachHang --
create table KhachHang (
	maKH nvarchar(10) primary key not null,
	tenKH nvarchar(50) not null,
	sDT nvarchar(12) not null,
	email nvarchar(30) not null,
	diaChi nvarchar(100),
	tieuPhiTichLuy float not null,
	--rank nvarchar(10),
	--constraint rank_cstr check (rank in (N'Đồng', N'Bạc', N'Vàng', N'Kim Cương')),
	rank nvarchar(10) references Rank(maRank)
		on delete cascade
		on update cascade,
	tichDiem float not null
)
go

-- table NhanVien --
create table NhanVien (
	maNV nvarchar(10) primary key not null,
	--maTaiKhoan nvarchar(10) not null references TaiKhoan(maTaiKhoan)
	--	on delete cascade
	--	on update cascade,
	tenNV nvarchar(50) not null,
	sDT nvarchar(12) not null,
	email nvarchar(30) not null,
	diaChi nvarchar(100) not null,
	trangThai nvarchar(10) not null check (trangThai in ('true', 'false')),
)

-- table loaiTK --
create table LoaiTK (
	maLoaiTK nvarchar(10) primary key not null,
	tenLoaiTK nvarchar(30),
)

-- table TaiKhoan --
create table TaiKhoan (
	maTaiKhoan nvarchar(10) primary key not null,
	maNV nvarchar(10) references NhanVien(maNV)
		on update cascade
		on delete cascade,
	tenNguoiDung nvarchar(30),
	username nvarchar(30) not null,
	password nvarchar(30) not null,
	loaiTK nvarchar(10) references LoaiTK(maLoaiTK)
		on update cascade
		on delete cascade,
)

-- table LoaiKM --
create table LoaiKM (
	maLoaiKM nvarchar(10) primary key not null,
	tenLoaiKM nvarchar(20)
)

-- table KhuyenMai --
create table KhuyenMai (
	maKM nvarchar(10) primary key not null,
	--loaiKM nvarchar(20) check (loaiKM in (N'Giảm theo %', N'giảm theo tiền')),
	loaiKM nvarchar(10) references LoaiKM(maLoaiKM)
		on update cascade
		on delete cascade,
	giaTriKhuyenMai float not null,
	ngayBatDau datetime not null,
	ngayKetThuc datetime not null,
	giaTriHoaDonBatDauKhuyenMai float not null
)

-- table NhaCungCap --
create table NhaCungCap (
	maNCC nvarchar(10) primary key not null,
	tenNCC nvarchar(50) not null,
	diaChi nvarchar(100) not null,
	sDT nvarchar(12) not null,
	email nvarchar(30) not null
)

-- tabel loaiSP --
create table LoaiSanPham (
	maLoaiSP nvarchar(10) primary key not null,
	tenLoai nvarchar(20)
)

-- table SanPham --
create table SanPham (
	maSP nvarchar(10) primary key not null,
	maKhuyenMai nvarchar(10) references KhuyenMai(maKM)
		on delete cascade
		on update cascade,
	maNCC nvarchar(10) references NhaCungCap(maNCC)
		on delete cascade
		on update cascade,
	tenSP nvarchar(50) not null,
	--loaiSP nvarchar(20) check (loaiSP in (N'SGK',N'truyện', N'tiểu thuyết' ,N'văn phòng phẩm', N'dụng cụ học tập')),
	loaiSP nvarchar(10) references LoaiSanPham(maLoaiSP)
		on delete cascade
		on update cascade,
	giaNhapHang float not null,
	giaBan float not null,
	soLuongBayBan int not null,
	soLuongTonKho int not null,
	VAT float
)

-- table HoaDon --
create table HoaDon (
	maHD nvarchar(10) primary key not null,
	maNhanVien nvarchar(10) references NhanVien(maNV)
		on delete cascade
		on update cascade,
	maKhachHang nvarchar(10) references KhachHang(maKH)
		on delete cascade
		on update cascade,
	ngayTao smalldatetime not null,
	tienKhachDua float not null,
	suDungTichDiem float,
	tongTien float,
	tongKM float,
	tongThue float,
	tienVon float,
)

-- table ChiTietHoaDon --
create table ChiTietHoaDon (
	maHoaDon nvarchar(10) not null references HoaDon(maHD) 
		on delete cascade
		on update cascade,
	maSanPham nvarchar(10) not null references SanPham(maSP)
		on delete cascade
		on update cascade,
	soLuong int not null,
	thanhTien float,
)

alter table ChiTietHoaDon
add primary key (maHoaDon, maSanPham);


-- table HoaDonNhapHang --
create table HoaDonNhapHang (
	maHDNH nvarchar(10) primary key not null,
	maNCC nvarchar(10) references NhaCungCap(maNCC)
		on delete cascade
		on update cascade,
	ngayNhap datetime not null,
	ghiChu nvarchar(200),
	thanhToan nvarchar(10)
)

-- table ChiTietHoaDonNhapHang --
create table ChiTietHoaDonNhapHang (
	maSP nvarchar(10) references SanPham(maSP)
		on delete cascade
		on update cascade,
	maHDNH nvarchar(10) references HoaDonNhapHang(maHDNH),
	soLuongNhap int not null,
	thue float,
)

-- table HoaDonDoiTra --


------------------ add data ---------------
-- NhanVien --
insert into NhanVien(maNV, tenNV, sDT, email, diaChi, trangThai)
values 
	('NV001', N'Nguyễn Minh Nhật', '0235136987', 'nhat@gmail.com', N'abc, Gò Vấp', 'true')

-- LoaiTK --
insert into LoaiTK(maLoaiTK, tenLoaiTK)
values 
	('LTK001', N'Tài khoản nhân viên bán hàng'),
	('LTK002', N'Tài khoản quản lý');

-- Tai Khoan --
insert into TaiKhoan(maTaiKhoan, maNV, tenNguoiDung ,username, password, loaiTK)
values 
	('TK001','NV001', N'Nguyễn Minh Nhật', 'nhatminh', 'nhatminhpass', 'LTK002'),
	('TK002','NV001', N'Vũ Quốc Huy', 'quochuy', 'quochuypass', 'LTK001'),
	('TK003','NV001', N'Nguyễn Thanh Tùng', 'thanhtung', 'thanhtungpass', 'LTK001'),
	('TK004','NV001', N'Trần Bảo Xuyên', 'baoxuyen', 'baoxuyenpass', 'LTK001');

-- Rank --
insert into Rank (maRank, tenRank, tiLeTichDiem)
values
	('R001', N'Đồng', 0.1),
	('R002', N'Bạc', 0.15),
	('R003', N'Vàng', 0.25),
	('R004', N'Kim Cương', 0.4)

-- Khach Hang --
INSERT INTO KhachHang (maKH, tenKH, sDT, email, tieuPhiTichLuy, rank, tichDiem)
VALUES
  ('KH001', 'Nguyễn Văn A', '0123456789', 'nguyenvana@example.com', 100000, 'R001', 50.0),
  ('KH002', 'Trần Thị B', '0987654321', 'tranthib@example.com', 200000, 'R002', 90.0),
  ('KH003', 'Lê Quang C', '0369852147', 'lequangc@example.com', 150000, 'R003', 70.0),
  ('KH004', 'Phạm Thanh D', '0765432198', 'phamthanhd@example.com', 300000, 'R004', 120.0),
  ('KH005', 'Hoàng Thị E', '0654321987', 'hoangthie@example.com', 120000, 'R001', 60.0),
  ('KH006', 'Vũ Xuân F', '0321987654', 'vuxuanf@example.com', 250000, 'R002', 100.0),
  ('KH007', 'Nguyễn Thị G', '0147852369', 'nguyenthigh@example.com', 180000, 'R003', 80.0),
  ('KH008', 'Trần Anh H', '0246897531', 'trananhh@example.com', 350000, 'R004', 140.0),
  ('KH009', 'Lê Quốc I', '0987654321', 'lequoci@example.com', 130000, 'R001', 65.0),
  ('KH010', 'Phạm Thị K', '0765432198', 'phamthik@example.com', 270000, 'R002', 110.0),
  ('KH011', 'Hoàng Xuân L', '0654321987', 'hoangxuanl@example.com', 160000, 'R003', 75.0),
  ('KH012', 'Vũ Thanh M', '0321987654', 'vuthanhm@example.com', 320000, 'R004', 130.0),
  ('KH013', 'Nguyễn Hữu N', '0147852369', 'nguyenhuun@example.com', 140000, 'R001', 70.0),
  ('KH014', 'Trần Văn O', '0246897531', 'tranvano@example.com', 290000, 'R002', 120.0),
  ('KH015', 'Lê Thị P', '0987654321', 'lethip@example.com', 190000, 'R003', 85.0),
  ('KH016', 'Phạm Quang Q', '0765432198', 'phamquangq@example.com', 400000, 'R004', 150.0),
  ('KH017', 'Hoàng Anh R', '0654321987', 'hoanganhr@example.com', 150000, 'R001', 75.0),
  ('KH018', 'Vũ Thị S', '0321987654', 'vuthis@example.com', 320000, 'R002', 130.0),
  ('KH019', 'Nguyễn Văn T', '0147852369', 'nguyenvant@example.com', 200000, 'R003', 90.0),
  ('KH020', 'Trần Thị U', '0246897531', 'tranthiu@example.com', 360000, 'R004', 140.0);

-- loaiKM --
INSERT INTO LoaiKM (maLoaiKM, tenLoaiKM)
VALUES
  ('LKM001', 'Giảm theo %'),
  ('LKM002', 'Giảm theo tiền'),
  ('LKM003', 'Mua 1 tặng 1');

-- KhuyenMai --
insert into KhuyenMai(maKM, loaiKM, giaTriKhuyenMai, ngayBatDau, ngayKetThuc, giaTriHoaDonBatDauKhuyenMai)
values 
	('KM001', 'LKM001', 0.1, '2023-11-13', '2023-11-17', 0),
	('KM002', 'LKM001', 0.05, '2023-11-13', '2023-11-17', 0),
	('KM003', 'LKM002', 10000, '2023-11-13', '2023-11-17', 0),
	('KM004', 'LKM002', 15000, '2023-11-13', '2023-11-17', 0);

-- HoaDon --
insert into HoaDon (maHD, maNhanVien, maKhachHang, ngayTao, tienKhachDua, 
					suDungTichDiem, tongTien, tongKM, tongThue, tienVon)
values
	('HD001', 'NV001', 'KH001', '2023-11-13', 500000, 5000, 225000, 0, 0, 100000),
	('HD002', 'NV001', 'KH002', '2023-11-13', 200000, 0, 67000, 0, 0, 40000),
	('HD003', 'NV001', 'KH003', '2023-11-13', 130000, 0, 117000, 0, 0, 100000),
	('HD004', 'NV001', 'KH004', '2023-11-13', 50000, 2000, 42000, 0, 0, 20000),
	('HD005', 'NV001', NULL, '2023-11-13', 70000, 0, 50000, 0, 0, 30000),
	('HD006', 'NV001', NULL, '2023-11-13', 100000, 0, 74000, 0, 0, 50000),
	('HD007', 'NV001', 'KH002', '2023-11-05', 68000, 0, 68000, 0, 0, 40000),
	('HD008', 'NV001', 'KH002', '2023-11-02', 68000, 0, 68000, 0, 0, 40000),
	('HD009', 'NV001', 'KH002', '2023-09-11', 68000, 0, 68000, 0, 0, 40000),
	('HD010', 'NV001', 'KH002', '2023-08-13', 68000, 0, 68000, 0, 0, 40000),
	('HD011', 'NV001', 'KH002', '2023-07-13', 68000, 0, 68000, 0, 0, 40000);



-- Nha CUng Cap --
INSERT INTO NhaCungCap (maNCC, tenNCC, diaChi, sDT, email)
VALUES
    ('NCC001', 'Nhà cung cấp 1', 'Địa chỉ 1', '0123456789', 'email1@example.com'),
    ('NCC002', 'Nhà cung cấp 2', 'Địa chỉ 2', '0123456789', 'email2@example.com'),
    ('NCC003', 'Nhà cung cấp 3', 'Địa chỉ 3', '0123456789', 'email3@example.com'),
    ('NCC004', 'Nhà cung cấp 4', 'Địa chỉ 4', '0123456789', 'email4@example.com'),
    ('NCC005', 'Nhà cung cấp 5', 'Địa chỉ 5', '0123456789', 'email5@example.com'),
    ('NCC006', 'Nhà cung cấp 6', 'Địa chỉ 6', '0123456789', 'email6@example.com'),
    ('NCC007', 'Nhà cung cấp 7', 'Địa chỉ 7', '0123456789', 'email7@example.com');

-- Loai SP --
insert into LoaiSanPham(maLoaiSP, tenLoai)
values 
	('LSP001', N'SGK'),
	('LSP002', N'Truyện'),
	('LSP003', N'Tiểu thuyết'),
	('LSP004', N'Dụng cụ học tập'),
	('LSP005', N'Văn phòng phẩm');

-- San Pham --
INSERT INTO SanPham (maSP, maKhuyenMai, maNCC, tenSP, loaiSP, giaNhapHang, giaBan, soLuongBayBan, soLuongTonKho)
VALUES
  ('SP001', 'KM001', 'NCC003', N'Sản phẩm 1', 'LSP001', 100000, 150000, 50, 100),
  ('SP002', 'KM001', 'NCC003', N'Sản phẩm 2', 'LSP003', 120000, 180000, 60, 90),
  ('SP003', 'KM002', 'NCC003', N'Sản phẩm 3', 'LSP001', 80000, 130000, 40, 120),
  ('SP004', 'KM001', 'NCC003', N'Sản phẩm 4', 'LSP005', 150000, 220000, 75, 80),
  ('SP005', 'KM003', 'NCC003', N'Sản phẩm 5', 'LSP004', 110000, 160000, 55, 110),
  ('SP006', 'KM002', 'NCC003', N'Sản phẩm 6', 'LSP004', 130000, 190000, 65, 95),
  ('SP007', 'KM004', 'NCC003', N'Sản phẩm 7', 'LSP003', 90000, 140000, 45, 105),
  ('SP008', 'KM001', 'NCC003', N'Sản phẩm 8', 'LSP002', 160000, 230000, 80, 70),
  ('SP009', NULL, 'NCC003', N'Sản phẩm 9', 'LSP005', 120000, 170000, 60, 120),
  ('SP010', NULL, 'NCC003', N'Sản phẩm 10', 'LSP001', 140000, 200000, 70, 90),
  ('SP011', NULL, 'NCC003', N'Sản phẩm 11', 'LSP002', 100000, 150000, 50, 100),
  ('SP012', 'KM004', 'NCC003', N'Sản phẩm 12', 'LSP002', 170000, 240000, 85, 70),
  ('SP013', NULL, 'NCC003', N'Sản phẩm 13', 'LSP002', 130000, 180000, 65, 110),
  ('SP014', NULL, 'NCC003', N'Sản phẩm 14', 'LSP003', 150000, 210000, 75, 90),
  ('SP015', NULL, 'NCC003', N'Sản phẩm 15', 'LSP005', 110000, 160000, 55, 105),
  ('SP016', NULL, 'NCC003', N'Sản phẩm 16', 'LSP001', 180000, 250000, 90, 65),
  ('SP017', 'KM002', 'NCC003', N'Sản phẩm 17', 'LSP002', 140000, 190000, 70, 100),
  ('SP018', NULL, 'NCC003', N'Sản phẩm 18', 'LSP005', 160000, 220000, 80, 85),
  ('SP019', NULL, 'NCC003', N'Sản phẩm 19', 'LSP004', 120000, 170000, 60, 120),
  ('SP020', NULL, 'NCC003', N'Sản phẩm 20', 'LSP002', 190000, 260000, 95, 60);

