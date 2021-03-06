USE [master]
GO
/****** Object:  Database [Cranio]    Script Date: 10/03/2021 20:32:34 ******/
CREATE DATABASE [Cranio]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Cranio', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.PROJECTS\MSSQL\DATA\Cranio.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 20%), 
 FILEGROUP [FgStreams] CONTAINS FILESTREAM  DEFAULT
( NAME = N'Fg_Streams', FILENAME = N'C:\Users\Gustavo\Documents\Escola\EC6' , MAXSIZE = UNLIMITED)
 LOG ON 
( NAME = N'Cranio_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.PROJECTS\MSSQL\DATA\Cranio_log.ldf' , SIZE = 1088KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Cranio] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Cranio].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Cranio] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Cranio] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Cranio] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Cranio] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Cranio] SET ARITHABORT OFF 
GO
ALTER DATABASE [Cranio] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [Cranio] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Cranio] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Cranio] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Cranio] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Cranio] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Cranio] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Cranio] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Cranio] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Cranio] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Cranio] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Cranio] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Cranio] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Cranio] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Cranio] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Cranio] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Cranio] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Cranio] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Cranio] SET  MULTI_USER 
GO
ALTER DATABASE [Cranio] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Cranio] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Cranio] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Cranio] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [Cranio] SET DELAYED_DURABILITY = DISABLED 
GO
USE [Cranio]
GO
/****** Object:  Table [dbo].[AccessGroup]    Script Date: 10/03/2021 20:32:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AccessGroup](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](100) NOT NULL,
	[description] [varchar](300) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Alternative]    Script Date: 10/03/2021 20:32:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Alternative](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[questionId] [int] NOT NULL,
	[content] [varchar](max) NOT NULL,
	[insertDate] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Course]    Script Date: 10/03/2021 20:32:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Course](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[matterId] [int] NOT NULL,
	[teacherId] [int] NOT NULL,
	[name] [varchar](250) NOT NULL,
	[duration] [time](7) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Difficulty]    Script Date: 10/03/2021 20:32:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Difficulty](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[code] [int] NOT NULL,
	[description] [varchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[code] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Lesson]    Script Date: 10/03/2021 20:32:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Lesson](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[courseId] [int] NOT NULL,
	[lessonGuid] [uniqueidentifier] ROWGUIDCOL  NOT NULL,
	[name] [varchar](250) NOT NULL,
	[resume] [varchar](500) NOT NULL,
	[order] [int] NOT NULL,
	[content] [varbinary](max) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Matter]    Script Date: 10/03/2021 20:32:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Matter](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[code] [int] NOT NULL,
	[name] [varchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[code] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Permission]    Script Date: 10/03/2021 20:32:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Permission](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[code] [int] NOT NULL,
	[name] [varchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [uni_code_permission] UNIQUE NONCLUSTERED 
(
	[code] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PermissionAccessGroup]    Script Date: 10/03/2021 20:32:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PermissionAccessGroup](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[permissionId] [int] NOT NULL,
	[accessGroupId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Question]    Script Date: 10/03/2021 20:32:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Question](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[difficultyId] [int] NOT NULL,
	[matterId] [int] NOT NULL,
	[fileGuid] [uniqueidentifier] ROWGUIDCOL  NOT NULL,
	[enunciated] [varchar](max) NOT NULL,
	[image] [varbinary](max) NULL,
	[answer] [varchar](max) NOT NULL,
	[insertDate] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Student]    Script Date: 10/03/2021 20:32:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Student](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[userId] [int] NOT NULL,
	[graduation] [varchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Teacher]    Script Date: 10/03/2021 20:32:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Teacher](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[userId] [int] NOT NULL,
	[lastDegree] [varchar](200) NOT NULL,
	[expecialization] [varchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Test]    Script Date: 10/03/2021 20:32:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Test](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[matterId] [int] NOT NULL,
	[difficultyId] [int] NOT NULL,
	[doPercentage] [decimal](14, 2) NOT NULL,
	[totalQuestions] [int] NOT NULL,
	[dateCreated] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TestQuestion]    Script Date: 10/03/2021 20:32:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TestQuestion](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[testId] [int] NOT NULL,
	[questionId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[User]    Script Date: 10/03/2021 20:32:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[User](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[avatarGuid] [uniqueidentifier] ROWGUIDCOL  NOT NULL,
	[name] [varchar](250) NOT NULL,
	[login] [varchar](100) NOT NULL,
	[password] [varchar](max) NOT NULL,
	[avatar] [varbinary](max) NULL,
	[accessGroupId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[Alternative]  WITH CHECK ADD  CONSTRAINT [fk_alternative_question_questionId] FOREIGN KEY([questionId])
REFERENCES [dbo].[Question] ([id])
GO
ALTER TABLE [dbo].[Alternative] CHECK CONSTRAINT [fk_alternative_question_questionId]
GO
ALTER TABLE [dbo].[Course]  WITH CHECK ADD  CONSTRAINT [fk_course_matter] FOREIGN KEY([matterId])
REFERENCES [dbo].[Matter] ([id])
GO
ALTER TABLE [dbo].[Course] CHECK CONSTRAINT [fk_course_matter]
GO
ALTER TABLE [dbo].[Course]  WITH CHECK ADD  CONSTRAINT [fk_course_teacher] FOREIGN KEY([teacherId])
REFERENCES [dbo].[Teacher] ([id])
GO
ALTER TABLE [dbo].[Course] CHECK CONSTRAINT [fk_course_teacher]
GO
ALTER TABLE [dbo].[Lesson]  WITH CHECK ADD  CONSTRAINT [fk_lesson_course_courseId] FOREIGN KEY([courseId])
REFERENCES [dbo].[Course] ([id])
GO
ALTER TABLE [dbo].[Lesson] CHECK CONSTRAINT [fk_lesson_course_courseId]
GO
ALTER TABLE [dbo].[PermissionAccessGroup]  WITH CHECK ADD  CONSTRAINT [fk_permissionAccessGroup_accessGroup_id] FOREIGN KEY([accessGroupId])
REFERENCES [dbo].[AccessGroup] ([id])
GO
ALTER TABLE [dbo].[PermissionAccessGroup] CHECK CONSTRAINT [fk_permissionAccessGroup_accessGroup_id]
GO
ALTER TABLE [dbo].[PermissionAccessGroup]  WITH CHECK ADD  CONSTRAINT [fk_permissionAccessGroup_permission_id] FOREIGN KEY([permissionId])
REFERENCES [dbo].[Permission] ([id])
GO
ALTER TABLE [dbo].[PermissionAccessGroup] CHECK CONSTRAINT [fk_permissionAccessGroup_permission_id]
GO
ALTER TABLE [dbo].[Question]  WITH CHECK ADD  CONSTRAINT [fk_question_difficulty_difficultyId] FOREIGN KEY([difficultyId])
REFERENCES [dbo].[Difficulty] ([id])
GO
ALTER TABLE [dbo].[Question] CHECK CONSTRAINT [fk_question_difficulty_difficultyId]
GO
ALTER TABLE [dbo].[Question]  WITH CHECK ADD  CONSTRAINT [fk_question_matter_matterId] FOREIGN KEY([matterId])
REFERENCES [dbo].[Matter] ([id])
GO
ALTER TABLE [dbo].[Question] CHECK CONSTRAINT [fk_question_matter_matterId]
GO
ALTER TABLE [dbo].[Student]  WITH CHECK ADD  CONSTRAINT [fk_student_user_userId] FOREIGN KEY([userId])
REFERENCES [dbo].[User] ([id])
GO
ALTER TABLE [dbo].[Student] CHECK CONSTRAINT [fk_student_user_userId]
GO
ALTER TABLE [dbo].[Teacher]  WITH CHECK ADD  CONSTRAINT [fk_teacher_user_userId] FOREIGN KEY([userId])
REFERENCES [dbo].[User] ([id])
GO
ALTER TABLE [dbo].[Teacher] CHECK CONSTRAINT [fk_teacher_user_userId]
GO
ALTER TABLE [dbo].[Test]  WITH CHECK ADD  CONSTRAINT [fk_test_dificulty_id] FOREIGN KEY([difficultyId])
REFERENCES [dbo].[Difficulty] ([id])
GO
ALTER TABLE [dbo].[Test] CHECK CONSTRAINT [fk_test_dificulty_id]
GO
ALTER TABLE [dbo].[Test]  WITH CHECK ADD  CONSTRAINT [fk_test_matter_id] FOREIGN KEY([matterId])
REFERENCES [dbo].[Matter] ([id])
GO
ALTER TABLE [dbo].[Test] CHECK CONSTRAINT [fk_test_matter_id]
GO
ALTER TABLE [dbo].[TestQuestion]  WITH CHECK ADD  CONSTRAINT [fk_testQuestion_question] FOREIGN KEY([questionId])
REFERENCES [dbo].[Question] ([id])
GO
ALTER TABLE [dbo].[TestQuestion] CHECK CONSTRAINT [fk_testQuestion_question]
GO
ALTER TABLE [dbo].[TestQuestion]  WITH CHECK ADD  CONSTRAINT [fk_testQuestions_test] FOREIGN KEY([testId])
REFERENCES [dbo].[Test] ([id])
GO
ALTER TABLE [dbo].[TestQuestion] CHECK CONSTRAINT [fk_testQuestions_test]
GO
ALTER TABLE [dbo].[User]  WITH CHECK ADD  CONSTRAINT [fk_user_accessGroup_id] FOREIGN KEY([accessGroupId])
REFERENCES [dbo].[AccessGroup] ([id])
GO
ALTER TABLE [dbo].[User] CHECK CONSTRAINT [fk_user_accessGroup_id]
GO
USE [master]
GO
ALTER DATABASE [Cranio] SET  READ_WRITE 
GO
