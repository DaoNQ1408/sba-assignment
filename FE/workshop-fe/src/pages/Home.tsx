import { Box, Typography, Button, Grid, Paper, AppBar, Toolbar, IconButton, Menu, MenuItem } from '@mui/material';
import MenuIcon from '@mui/icons-material/Menu';
import { useState } from 'react';

const Home = () => {
    const [anchorEl, setAnchorEl] = useState<null | HTMLElement>(null);
    const open = Boolean(anchorEl);
    const handleClick = (event: React.MouseEvent<HTMLElement>) => {
        setAnchorEl(event.currentTarget);
    };
    const handleClose = () => {
        setAnchorEl(null);
    };

    const menuItems = [
        { label: 'Chương trình đào tạo', link: '#' },
        { label: 'Tuyển sinh', link: '#' },
        { label: 'Tin tức', link: '#' },
        { label: 'Sự kiện', link: '#' },
        { label: 'Về chúng tôi', link: '#' },
    ];

    return (
        <Box sx={{ bgcolor: '#fff', minHeight: '100vh' }}>
            {/* Header */}
            <AppBar position="static" sx={{ bgcolor: '#FF6F00' }}>
                <Toolbar>
                    <IconButton
                        size="large"
                        edge="start"
                        color="inherit"
                        aria-label="menu"
                        sx={{ mr: 2, display: { xs: 'block', md: 'none' } }}
                        onClick={handleClick}
                    >
                        <MenuIcon />
                    </IconButton>
                    <Menu
                        id="basic-menu"
                        anchorEl={anchorEl}
                        open={open}
                        onClose={handleClose}
                        MenuListProps={{
                            'aria-labelledby': 'basic-button',
                        }}
                    >
                        {menuItems.map((item, index) => (
                            <MenuItem key={index} onClick={handleClose}>
                                {item.label}
                            </MenuItem>
                        ))}
                    </Menu>
                    <Box sx={{ display: 'flex', alignItems: 'center', gap: 2 }}>
                        <img
                            src="/fpt-logo.png"
                            alt="FPT Logo"
                            style={{ height: 40 }}
                        />
                        <Typography
                            variant="h6"
                            sx={{
                                color: '#fff',
                                fontWeight: 700,
                                letterSpacing: 1,
                            }}
                        >
                            TRƯỜNG ĐẠI HỌC FPT
                        </Typography>
                    </Box>
                    <Box sx={{ flexGrow: 1, display: { xs: 'none', md: 'flex' }, justifyContent: 'flex-end', gap: 2 }}>
                        {menuItems.map((item, index) => (
                            <Button key={index} color="inherit" href={item.link}>
                                {item.label}
                            </Button>
                        ))}
                        <Button
                            variant="contained"
                            sx={{
                                bgcolor: '#fff',
                                color: '#FF6F00',
                                fontWeight: 600,
                                boxShadow: 'none',
                                '&:hover': { bgcolor: '#ffe0b2' },
                            }}
                        >
                            Đăng nhập
                        </Button>
                    </Box>
                </Toolbar>
            </AppBar>

            {/* Hero Section */}
            <Box
                sx={{
                    background: 'url("/background.jpg") center/cover no-repeat',
                    minHeight: 420,
                    display: 'flex',
                    flexDirection: 'column',
                    alignItems: 'center',
                    justifyContent: 'center',
                    textAlign: 'center',
                    px: 2,
                    position: 'relative',
                }}
            >
                <Box
                    sx={{
                        position: 'absolute',
                        inset: 0,
                        bgcolor: 'rgba(255,111,0,0.25)',
                        zIndex: 1,
                    }}
                />
                <Box sx={{ position: 'relative', zIndex: 2 }}>
                    <Typography
                        variant="h3"
                        sx={{
                            color: '#FF6F00',
                            fontWeight: 700,
                            mt: 8,
                            mb: 2,
                            letterSpacing: 2,
                            textShadow: '0 2px 8px rgba(0,0,0,0.08)',
                        }}
                    >
                        Chào mừng đến với Đại học FPT
                    </Typography>
                    <Typography
                        variant="h6"
                        sx={{
                            color: '#fff',
                            fontWeight: 400,
                            mb: 4,
                            textShadow: '0 2px 8px rgba(0,0,0,0.2)',
                        }}
                    >
                        Nơi khởi đầu cho tương lai của bạn
                    </Typography>
                    <Button
                        variant="contained"
                        sx={{
                            bgcolor: '#FF6F00',
                            color: '#fff',
                            fontWeight: 600,
                            fontSize: 18,
                            px: 4,
                            py: 1.5,
                            borderRadius: 2,
                            boxShadow: 2,
                            '&:hover': { bgcolor: '#e65c00' },
                        }}
                    >
                        Tìm hiểu thêm
                    </Button>
                </Box>
            </Box>

            {/* Info Section */}
            <Box
                sx={{
                    maxWidth: 1100,
                    mx: 'auto',
                    mt: 6,
                    px: 2,
                    py: 4,
                }}
            >
                <Grid container spacing={4}>
                    <Grid item xs={12} md={4}>
                        <Paper elevation={2} sx={{ p: 3, textAlign: 'center', borderTop: '4px solid #FF6F00' }}>
                            <Typography variant="h6" sx={{ color: '#FF6F00', fontWeight: 700, mb: 1 }}>
                                Chương trình đào tạo
                            </Typography>
                            <Typography variant="body2" sx={{ color: '#333' }}>
                                Đa dạng ngành học: CNTT, Kinh tế, Ngôn ngữ, Thiết kế... với chương trình chuẩn quốc tế.
                            </Typography>
                        </Paper>
                    </Grid>
                    <Grid item xs={12} md={4}>
                        <Paper elevation={2} sx={{ p: 3, textAlign: 'center', borderTop: '4px solid #FF6F00' }}>
                            <Typography variant="h6" sx={{ color: '#FF6F00', fontWeight: 700, mb: 1 }}>
                                Môi trường hiện đại
                            </Typography>
                            <Typography variant="body2" sx={{ color: '#333' }}>
                                Cơ sở vật chất tiên tiến, khuôn viên xanh, không gian sáng tạo và năng động.
                            </Typography>
                        </Paper>
                    </Grid>
                    <Grid item xs={12} md={4}>
                        <Paper elevation={2} sx={{ p: 3, textAlign: 'center', borderTop: '4px solid #FF6F00' }}>
                            <Typography variant="h6" sx={{ color: '#FF6F00', fontWeight: 700, mb: 1 }}>
                                Hỗ trợ sinh viên
                            </Typography>
                            <Typography variant="body2" sx={{ color: '#333' }}>
                                Tư vấn tuyển sinh, học bổng, hoạt động ngoại khóa, hỗ trợ việc làm sau tốt nghiệp.
                            </Typography>
                        </Paper>
                    </Grid>
                </Grid>
            </Box>

            {/* Footer */}
            <Box
                sx={{
                    bgcolor: '#FF6F00',
                    color: '#fff',
                    py: 3,
                    mt: 8,
                    textAlign: 'center',
                }}
            >
                <Typography variant="body2">
                    Địa chỉ: Khu Công nghệ cao, Quận 9, TP. Hồ Chí Minh | Hotline: 1900 7300
                </Typography>
                <Typography variant="body2" sx={{ mt: 1 }}>
                    &copy; {new Date().getFullYear()} Đại học FPT. All rights reserved.
                </Typography>
            </Box>
        </Box>
    );
};

export default Home;
