import { Box, Typography } from "@mui/material";
import React from "react";


const Footer: React.FC = () => {
  return (
    <Box
        component="footer"
        sx={{
            mt: 4,
            pt: 2.5,
            pb: 1.5,
            textAlign: 'center',
            borderTop: '1px solid',
            borderColor: 'divider'
        }}
    >

        <Typography variant="body2" color="text.secondary" sx={{fontWeight: 500}}>
            {new Date().getFullYear()} FPT University - Hệ thống
        </Typography>
    </Box>
  );
}

export default Footer;
