-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 21, 2021 at 12:40 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `accident_alert_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `accident_alert`
--

CREATE TABLE `accident_alert` (
  `r_id` int(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `place` varchar(20) NOT NULL,
  `accident_alert` varchar(20) NOT NULL,
  `time` varchar(20) NOT NULL,
  `date` varchar(20) NOT NULL,
  `latitude` varchar(100) NOT NULL,
  `longtitude` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accident_alert`
--

INSERT INTO `accident_alert` (`r_id`, `name`, `place`, `accident_alert`, `time`, `date`, `latitude`, `longtitude`) VALUES
(4, 'kumbalam', 'calicut', 'Accident Alert', '17:21:09.268067', '2021-04-20', '11.2597019', '75.7875195'),
(6, 'qq', 'calicut', 'Accident Alert', '17:30:07.772023', '2021-04-20', '11.2596941', '75.7875028'),
(7, 'kumbalam', 'calicut', 'Accident Alert', '16:05:22.388385', '2021-04-21', '11.2597067', '75.7875229'),
(8, 'kumbalam', 'calicut', 'Accident Alert', '16:05:32.617608', '2021-04-21', '11.2597067', '75.7875229'),
(9, 'kumbalam', 'calicut', 'Accident Alert', '16:05:39.355205', '2021-04-21', '11.2597067', '75.7875229'),
(10, 'kumbalam', 'calicut', 'Accident Alert', '16:05:42.131398', '2021-04-21', '11.2597067', '75.7875229'),
(12, 'kumbalam', 'calicut', 'Accident Alert', '16:06:06.122695', '2021-04-21', '11.2597067', '75.7875229'),
(14, 'kumbalam', 'calicut', 'Accident Alert', '16:06:36.905564', '2021-04-21', '11.2597067', '75.7875229');

-- --------------------------------------------------------

--
-- Table structure for table `auth_group`
--

CREATE TABLE `auth_group` (
  `id` int(11) NOT NULL,
  `name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `auth_group_permissions`
--

CREATE TABLE `auth_group_permissions` (
  `id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `auth_permission`
--

CREATE TABLE `auth_permission` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `content_type_id` int(11) NOT NULL,
  `codename` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `auth_permission`
--

INSERT INTO `auth_permission` (`id`, `name`, `content_type_id`, `codename`) VALUES
(1, 'Can add log entry', 1, 'add_logentry'),
(2, 'Can change log entry', 1, 'change_logentry'),
(3, 'Can delete log entry', 1, 'delete_logentry'),
(4, 'Can view log entry', 1, 'view_logentry'),
(5, 'Can add permission', 2, 'add_permission'),
(6, 'Can change permission', 2, 'change_permission'),
(7, 'Can delete permission', 2, 'delete_permission'),
(8, 'Can view permission', 2, 'view_permission'),
(9, 'Can add group', 3, 'add_group'),
(10, 'Can change group', 3, 'change_group'),
(11, 'Can delete group', 3, 'delete_group'),
(12, 'Can view group', 3, 'view_group'),
(13, 'Can add user', 4, 'add_user'),
(14, 'Can change user', 4, 'change_user'),
(15, 'Can delete user', 4, 'delete_user'),
(16, 'Can view user', 4, 'view_user'),
(17, 'Can add content type', 5, 'add_contenttype'),
(18, 'Can change content type', 5, 'change_contenttype'),
(19, 'Can delete content type', 5, 'delete_contenttype'),
(20, 'Can view content type', 5, 'view_contenttype'),
(21, 'Can add session', 6, 'add_session'),
(22, 'Can change session', 6, 'change_session'),
(23, 'Can delete session', 6, 'delete_session'),
(24, 'Can view session', 6, 'view_session');

-- --------------------------------------------------------

--
-- Table structure for table `auth_user`
--

CREATE TABLE `auth_user` (
  `id` int(11) NOT NULL,
  `password` varchar(128) NOT NULL,
  `last_login` datetime(6) DEFAULT NULL,
  `is_superuser` tinyint(1) NOT NULL,
  `username` varchar(150) NOT NULL,
  `first_name` varchar(150) NOT NULL,
  `last_name` varchar(150) NOT NULL,
  `email` varchar(254) NOT NULL,
  `is_staff` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `date_joined` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `auth_user_groups`
--

CREATE TABLE `auth_user_groups` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `auth_user_user_permissions`
--

CREATE TABLE `auth_user_user_permissions` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `complaint`
--

CREATE TABLE `complaint` (
  `c_id` int(10) NOT NULL,
  `u_id` int(10) NOT NULL,
  `complaint` varchar(50) NOT NULL,
  `date` date NOT NULL,
  `reply` varchar(50) NOT NULL,
  `image` varchar(500) NOT NULL,
  `Status` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `complaint`
--

INSERT INTO `complaint` (`c_id`, `u_id`, `complaint`, `date`, `reply`, `image`, `Status`) VALUES
(22, 0, 'signal not working', '2021-04-09', 'forwarded', '22.jpg', 'ok'),
(23, 7, 'pitholes on road', '2021-04-09', 'forwarded', '23.jpg', 'pending'),
(24, 0, 'Parking at no parking', '2021-04-09', 'pending', '24.jpg', 'pending');

-- --------------------------------------------------------

--
-- Table structure for table `dangerous_location`
--

CREATE TABLE `dangerous_location` (
  `d_id` int(11) NOT NULL,
  `alert` varchar(20) NOT NULL,
  `date` varchar(20) NOT NULL,
  `time` varchar(20) NOT NULL,
  `location` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dangerous_location`
--

INSERT INTO `dangerous_location` (`d_id`, `alert`, `date`, `time`, `location`) VALUES
(1, 'DCFVC', '2021-02-12', '14:52', 'dfhhj'),
(2, 'DCFVC', '2021-02-12', '14:52', 'dfhhj'),
(3, 'DCFVC', '2021-02-12', '14:52', 'dfhhj');

-- --------------------------------------------------------

--
-- Table structure for table `django_admin_log`
--

CREATE TABLE `django_admin_log` (
  `id` int(11) NOT NULL,
  `action_time` datetime(6) NOT NULL,
  `object_id` longtext DEFAULT NULL,
  `object_repr` varchar(200) NOT NULL,
  `action_flag` smallint(5) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `django_content_type`
--

CREATE TABLE `django_content_type` (
  `id` int(11) NOT NULL,
  `app_label` varchar(100) NOT NULL,
  `model` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `django_content_type`
--

INSERT INTO `django_content_type` (`id`, `app_label`, `model`) VALUES
(1, 'admin', 'logentry'),
(3, 'auth', 'group'),
(2, 'auth', 'permission'),
(4, 'auth', 'user'),
(5, 'contenttypes', 'contenttype'),
(6, 'sessions', 'session');

-- --------------------------------------------------------

--
-- Table structure for table `django_migrations`
--

CREATE TABLE `django_migrations` (
  `id` int(11) NOT NULL,
  `app` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `applied` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `django_migrations`
--

INSERT INTO `django_migrations` (`id`, `app`, `name`, `applied`) VALUES
(1, 'contenttypes', '0001_initial', '2021-02-03 20:49:21.185754'),
(2, 'auth', '0001_initial', '2021-02-03 20:49:22.201348'),
(3, 'admin', '0001_initial', '2021-02-03 20:49:27.716801'),
(4, 'admin', '0002_logentry_remove_auto_add', '2021-02-03 20:49:29.435504'),
(5, 'admin', '0003_logentry_add_action_flag_choices', '2021-02-03 20:49:29.513621'),
(6, 'contenttypes', '0002_remove_content_type_name', '2021-02-03 20:49:30.091727'),
(7, 'auth', '0002_alter_permission_name_max_length', '2021-02-03 20:49:30.185474'),
(8, 'auth', '0003_alter_user_email_max_length', '2021-02-03 20:49:30.294846'),
(9, 'auth', '0004_alter_user_username_opts', '2021-02-03 20:49:30.326098'),
(10, 'auth', '0005_alter_user_last_login_null', '2021-02-03 20:49:31.326069'),
(11, 'auth', '0006_require_contenttypes_0002', '2021-02-03 20:49:31.357318'),
(12, 'auth', '0007_alter_validators_add_error_messages', '2021-02-03 20:49:31.419817'),
(13, 'auth', '0008_alter_user_username_max_length', '2021-02-03 20:49:31.497939'),
(14, 'auth', '0009_alter_user_last_name_max_length', '2021-02-03 20:49:31.591686'),
(15, 'auth', '0010_alter_group_name_max_length', '2021-02-03 20:49:31.669810'),
(16, 'auth', '0011_update_proxy_permissions', '2021-02-03 20:49:31.747927'),
(17, 'auth', '0012_alter_user_first_name_max_length', '2021-02-03 20:49:31.810430'),
(18, 'sessions', '0001_initial', '2021-02-03 20:49:32.013544');

-- --------------------------------------------------------

--
-- Table structure for table `django_session`
--

CREATE TABLE `django_session` (
  `session_key` varchar(40) NOT NULL,
  `session_data` longtext NOT NULL,
  `expire_date` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `django_session`
--

INSERT INTO `django_session` (`session_key`, `session_data`, `expire_date`) VALUES
('3xeqq2crp4bsn5uww99hauqfhkkmrrbd', 'Y2M1YzM4MTE4OTQzN2M2MzUwM2JhN2VlZGVhMDQ0ZjlhNjQxNDRhYzp7InVpZCI6MH0=', '2021-04-16 09:35:19.799642'),
('8hjzwjci6mby14a4r9pnfn27v7ra3urf', 'YzU4YjIzMmQzYmJhYmY5YTY2ZWFkNGFjNzg5ZTc4N2FhMWU3OWVjMjp7InVpZCI6MTF9', '2021-04-13 09:02:45.248617'),
('9cpx9x2srtk2qy37jgkimti9xw4y7r4u', 'Y2M1YzM4MTE4OTQzN2M2MzUwM2JhN2VlZGVhMDQ0ZjlhNjQxNDRhYzp7InVpZCI6MH0=', '2021-04-19 07:40:39.036002'),
('fb5f4kj7x5qs6nz0t3lj8ygevhh8992i', 'YzU4YjIzMmQzYmJhYmY5YTY2ZWFkNGFjNzg5ZTc4N2FhMWU3OWVjMjp7InVpZCI6MTF9', '2021-04-16 09:51:42.238161'),
('kgykqveaw5qvi8bxameov6twd30jhjcx', 'MmM5NGY5NmZlZGFlNGY3ZGYzNzk3NTU5NGNmMzJiZjVkMDY0NDE3Njp7InVpZCI6M30=', '2021-02-26 10:08:28.496744'),
('v98y0jektktwgbgkrgqym6vao6jeo5k7', 'eyJ1aWQiOjB9:1l9atm:KHCdkeVcm5vSluo3X3EqNhICNq5VAmy9CX5TOvOr48c', '2021-02-23 21:50:18.098880'),
('xfbphvd6ecijnqpnnsp1dsci8qtlrnm5', 'eyJ1aWQiOjN9:1lZ93q:joreX5jeRGHFp9N3TXhDnaHOXP-fzc3TRX5_DogqpSk', '2021-05-05 09:22:18.311286'),
('z12izyozl8wsskwoowl9i0nondcdfs74', 'MmM5NGY5NmZlZGFlNGY3ZGYzNzk3NTU5NGNmMzJiZjVkMDY0NDE3Njp7InVpZCI6M30=', '2021-04-16 09:20:35.444169');

-- --------------------------------------------------------

--
-- Table structure for table `hospital`
--

CREATE TABLE `hospital` (
  `h_id` int(10) NOT NULL,
  `h_name` varchar(20) NOT NULL,
  `address` varchar(20) NOT NULL,
  `place` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hospital`
--

INSERT INTO `hospital` (`h_id`, `h_name`, `address`, `place`, `phone`, `email`) VALUES
(1, 'ohm', 'yvuftnuyg', 'uniygtf', '2583658686', 'srysru@gmail.com'),
(2, 'baby memorial', 'araidathupalam', 'araidathpalam', '7012773733', 'agl@gmail.com'),
(3, 'baby memorial', 'araidathpalam', 'araidathpalam', '7012773733', 'agl@gmail.com'),
(4, 'ohm', 'yvuftnuyg', 'uniygtf', '2583658686', 'srysru@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `loc_id` int(10) NOT NULL,
  `latitude` varchar(20) NOT NULL,
  `longtitude` varchar(20) NOT NULL,
  `location` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`loc_id`, `latitude`, `longtitude`, `location`) VALUES
(1, '12230', '12556', 'kjkhg');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `log_id` int(10) NOT NULL,
  `u_id` int(10) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`log_id`, `u_id`, `username`, `password`, `type`) VALUES
(2, 1, 'police1@gmail.com', 'police', 'Police'),
(3, 0, 'admin@gmail.com', 'admin', 'admin'),
(4, 6, 'FLUTEMANI@gmail.com', 'fjfgfghjghkjghjl', 'Police'),
(5, 7, 'FLUTEMANI@gmail.com', 'uguyfguy', 'Police'),
(6, 11, 'beyporep@gmail.com', 'dfgh', 'Police'),
(7, 3, 'h', 'h', 'hospital'),
(8, 4, 'dd@gmail.com', 'ddd', 'user'),
(9, 5, '', '', 'user'),
(10, 1, 'user', 'user', 'user'),
(11, 6, 't', 't', 'user'),
(12, 7, 'qq', 'qq', 'user'),
(13, 12, 'pp@gmail.com', 'pp', 'Police');

-- --------------------------------------------------------

--
-- Table structure for table `police`
--

CREATE TABLE `police` (
  `p_id` int(10) NOT NULL,
  `p_name` varchar(50) NOT NULL,
  `place` varchar(20) NOT NULL,
  `district` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `police`
--

INSERT INTO `police` (`p_id`, `p_name`, `place`, `district`, `email`, `phone`) VALUES
(2, 'MANI', 'fhff', 'KOLLAM', 'FLUTEMANI@gmail.com', '7547658'),
(3, 'MANI', 'fhff', 'KOLLAM', 'FLUTEMANI@gmail.com', '7547658'),
(4, 'MANI', 'gfcghg', 'ALAPPUZHA', 'FLUTEMANI@gmail.com', '564'),
(5, 'MANI', 'tye5yety', 'ALAPPUZHA', 'FLUTEMANI@gmail.com', '574545656'),
(6, 'MANI', 'rfhdgdfgf', 'KOTTAYAM', 'FLUTEMANI@gmail.com', '547474768'),
(7, 'MANI', 'iugiu', 'KOLLAM', 'FLUTEMANI@gmail.com', '765875'),
(11, 'beypore police station', 'beypore', 'KOZHIKODE', 'beyporep@gmail.com', '7012773735'),
(12, 'mankavu', 'mankavu', 'KOZHIKODE', 'pp@gmail.com', '7012773735');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `u_id` int(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `place` varchar(20) NOT NULL,
  `address` varchar(50) NOT NULL,
  `email` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`u_id`, `name`, `place`, `address`, `email`, `phone`) VALUES
(1, 'kumbalam', 'kundalpettu', 'kundelpettu house', 'avinashkumb@gmail.co', '123456789'),
(2, 'kumbalam', 'kundalpettu', 'kundelpettu house', '', '123456789'),
(3, 'kumbalam', 'kundalpettu', 'kundelpettu house', 'avinashkumb@gmail.co', '123456789'),
(4, 'dddd', 'dddd', 'ddddd', 'dd@gmail.com', '123456'),
(5, '', '', '', '', ''),
(6, 'o', 'o', 'o', 't', '2134567890'),
(7, 'qq', 'qq', 'qq', 'qq', '54646464');

-- --------------------------------------------------------

--
-- Table structure for table `violation`
--

CREATE TABLE `violation` (
  `v_id` int(10) NOT NULL,
  `violation_type` varchar(20) NOT NULL,
  `fine` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `violation`
--

INSERT INTO `violation` (`v_id`, `violation_type`, `fine`) VALUES
(1, 'DRUKEN DRIVE', '10000'),
(2, 'wdefd', '56'),
(3, 'DRUKEN DRIVE', '10000');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accident_alert`
--
ALTER TABLE `accident_alert`
  ADD PRIMARY KEY (`r_id`);

--
-- Indexes for table `auth_group`
--
ALTER TABLE `auth_group`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `auth_group_permissions`
--
ALTER TABLE `auth_group_permissions`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `auth_group_permissions_group_id_permission_id_0cd325b0_uniq` (`group_id`,`permission_id`),
  ADD KEY `auth_group_permissio_permission_id_84c5c92e_fk_auth_perm` (`permission_id`);

--
-- Indexes for table `auth_permission`
--
ALTER TABLE `auth_permission`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `auth_permission_content_type_id_codename_01ab375a_uniq` (`content_type_id`,`codename`);

--
-- Indexes for table `auth_user`
--
ALTER TABLE `auth_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `auth_user_groups`
--
ALTER TABLE `auth_user_groups`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `auth_user_groups_user_id_group_id_94350c0c_uniq` (`user_id`,`group_id`),
  ADD KEY `auth_user_groups_group_id_97559544_fk_auth_group_id` (`group_id`);

--
-- Indexes for table `auth_user_user_permissions`
--
ALTER TABLE `auth_user_user_permissions`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `auth_user_user_permissions_user_id_permission_id_14a6b632_uniq` (`user_id`,`permission_id`),
  ADD KEY `auth_user_user_permi_permission_id_1fbb5f2c_fk_auth_perm` (`permission_id`);

--
-- Indexes for table `complaint`
--
ALTER TABLE `complaint`
  ADD PRIMARY KEY (`c_id`);

--
-- Indexes for table `dangerous_location`
--
ALTER TABLE `dangerous_location`
  ADD PRIMARY KEY (`d_id`);

--
-- Indexes for table `django_content_type`
--
ALTER TABLE `django_content_type`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `django_content_type_app_label_model_76bd3d3b_uniq` (`app_label`,`model`);

--
-- Indexes for table `django_migrations`
--
ALTER TABLE `django_migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `django_session`
--
ALTER TABLE `django_session`
  ADD PRIMARY KEY (`session_key`),
  ADD KEY `django_session_expire_date_a5c62663` (`expire_date`);

--
-- Indexes for table `hospital`
--
ALTER TABLE `hospital`
  ADD PRIMARY KEY (`h_id`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`loc_id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`log_id`);

--
-- Indexes for table `police`
--
ALTER TABLE `police`
  ADD PRIMARY KEY (`p_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`u_id`);

--
-- Indexes for table `violation`
--
ALTER TABLE `violation`
  ADD PRIMARY KEY (`v_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accident_alert`
--
ALTER TABLE `accident_alert`
  MODIFY `r_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `auth_group`
--
ALTER TABLE `auth_group`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `auth_group_permissions`
--
ALTER TABLE `auth_group_permissions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `auth_permission`
--
ALTER TABLE `auth_permission`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `auth_user`
--
ALTER TABLE `auth_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `auth_user_groups`
--
ALTER TABLE `auth_user_groups`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `auth_user_user_permissions`
--
ALTER TABLE `auth_user_user_permissions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `complaint`
--
ALTER TABLE `complaint`
  MODIFY `c_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `dangerous_location`
--
ALTER TABLE `dangerous_location`
  MODIFY `d_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `django_content_type`
--
ALTER TABLE `django_content_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `hospital`
--
ALTER TABLE `hospital`
  MODIFY `h_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `loc_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `log_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `police`
--
ALTER TABLE `police`
  MODIFY `p_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `u_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `violation`
--
ALTER TABLE `violation`
  MODIFY `v_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
