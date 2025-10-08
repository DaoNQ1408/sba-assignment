import React, { useState } from 'react';
import { TextField, Button, Box } from '@mui/material';

const Login = () => {
    // Correctly destructure useState to get both the variable and the setter function
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        // This check will now work as expected
        if (!username || !password) {
            alert('Please enter both username and password.');
            return;
        }
        console.log('username', username);
        console.log('password', password);
        // You would typically send the data to a server here
    };

    return (
        <>
            <Box component="form" onSubmit={handleSubmit} sx={{ display: 'flex', flexDirection: 'column', gap: 2, width: '300px' }}>
                {/* Call the setter function in onChange */}
                <TextField
                    id="username"
                    label="Username"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                />
                <TextField
                    id="password"
                    label="Password"
                    type="password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />
                <Button type="submit" variant="contained" color="primary">
                    Sign In
                </Button>
            </Box>
        </>
    );
};

export default Login;
