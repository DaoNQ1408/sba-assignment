import React, { useState } from 'react';
import { TextField, Button, Box, Typography, Paper, Divider, IconButton, InputAdornment } from '@mui/material';
import GoogleIcon from '@mui/icons-material/Google';
import Visibility from '@mui/icons-material/Visibility';
import VisibilityOff from '@mui/icons-material/VisibilityOff';
import { authService } from '../services/authService';

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [showPassword, setShowPassword] = useState(false);

    const handleClickShowPassword = () => {
        setShowPassword(!showPassword);
    };

    const handleMouseDownPassword = (event: React.MouseEvent<HTMLElement>) => {
        event.preventDefault();
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        if (!username || !password) {
            alert('Please enter both username and password.');
            return;
        }

        try {
            const response = await authService.login({ username, password });
            console.log(response);
            // Xử lý response ở đây, ví dụ: chuyển hướng trang, hiển thị thông báo thành công/thất bại
        } catch (error) {
            console.error('Login failed:', error);
            // Xử lý lỗi ở đây, ví dụ: hiển thị thông báo lỗi cho người dùng
        }
    };

    return (
        <Box
            sx={{
                minHeight: '100vh',
                width: '100vw',
                background: 'url("/background.jpg") center/cover no-repeat', // Replace with your image path
                display: 'flex',
                alignItems: 'center',
                justifyContent: 'center',
                bgcolor: '#FF6F00', // FPT orange overlay
            }}
        >
            <Paper
                elevation={6}
                sx={{
                    display: 'flex',
                    flexDirection: { xs: 'column', md: 'row' },
                    minWidth: { xs: 350, md: 800 },
                    minHeight: 400,
                    borderRadius: 4,
                    overflow: 'hidden',
                }}
            >
                {/* Left side: Login form */}
                <Box
                    sx={{
                        flex: 1,
                        bgcolor: '#fff',
                        p: 5,
                        display: 'flex',
                        flexDirection: 'column',
                        alignItems: 'center',
                        justifyContent: 'center',
                    }}
                >
                    <img
                        src="/fpt-logo.png" // Replace with your logo path
                        alt="FPT Logo"
                        style={{ height: 50, marginBottom: 16 }}
                    />
                    <Typography
                        variant="h5"
                        sx={{
                            fontWeight: 700,
                            color: '#FF6F00',
                            mb: 2,
                            textAlign: 'center',
                            letterSpacing: 1,
                        }}
                    >
                        TRƯỜNG ĐẠI HỌC FPT
                    </Typography>
                    <Box
                        component="form"
                        onSubmit={handleSubmit}
                        sx={{ width: '100%', maxWidth: 320, display: 'flex', flexDirection: 'column', gap: 2 }}
                    >
                        <TextField
                            id="username"
                            label="Username"
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                            fullWidth
                        />
                        <TextField
                            id="password"
                            label="Password"
                            type={showPassword ? "text" : "password"}
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            fullWidth
                            InputProps={{
                                endAdornment: (
                                    <InputAdornment position="end">
                                        <IconButton
                                            aria-label="toggle password visibility"
                                            onClick={handleClickShowPassword}
                                            onMouseDown={handleMouseDownPassword}
                                            edge="end"
                                        >
                                            {showPassword ? <VisibilityOff /> : <Visibility />}
                                        </IconButton>
                                    </InputAdornment>
                                ),
                            }}
                        />
                        <Button
                            type="submit"
                            variant="contained"
                            sx={{
                                bgcolor: '#FF6F00',
                                color: '#fff',
                                fontWeight: 600,
                                fontSize: 16,
                                py: 1.5,
                                '&:hover': { bgcolor: '#e65c00' },
                            }}
                            fullWidth
                        >
                            Log in
                        </Button>
                    </Box>
                    <Typography variant="body2" sx={{ mt: 2, color: '#FF6F00', cursor: 'pointer' }}>
                        Lost password?
                    </Typography>
                </Box>
                {/* Right side: Google sign-in and notice */}
                <Box
                    sx={{
                        flex: 1,
                        bgcolor: '#fafafa',
                        p: 5,
                        display: 'flex',
                        flexDirection: 'column',
                        alignItems: 'center',
                        justifyContent: 'center',
                        borderLeft: { md: '1px solid #eee' },
                    }}
                >
                    <Typography variant="h6" sx={{ mb: 3, color: '#333' }}>
                        Sign in with
                    </Typography>
                    <Button
                        variant="outlined"
                        startIcon={<GoogleIcon />}
                        sx={{
                            bgcolor: '#fff',
                            color: '#333',
                            borderColor: '#FF6F00',
                            mb: 2,
                            fontWeight: 500,
                            '&:hover': { borderColor: '#e65c00', bgcolor: '#fff' },
                        }}
                        fullWidth
                    >
                        @fpt.edu.vn (For lecturer only)
                    </Button>
                    <Divider sx={{ width: '100%', my: 2 }} />
                    <Typography variant="body2" sx={{ color: '#FF6F00', display: 'flex', alignItems: 'center', gap: 1 }}>
                        <span style={{ fontSize: 18, verticalAlign: 'middle' }}>❓</span>
                        Cookies notice
                    </Typography>
                </Box>
            </Paper>
        </Box>
    );
};

export default Login;
