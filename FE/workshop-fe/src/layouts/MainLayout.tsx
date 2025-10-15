import React from "react";
import { Box } from "@mui/material";
import Footer from "../components/Footer";

interface MainLayoutProps {
  children: React.ReactNode;
}

const MainLayout: React.FC<MainLayoutProps> = ({ children }) => {
  return (
    <>
      <Box sx={{ display: "flex" }}>
        <Box
          sx={{
            flexGrow: 1,
            display: "flex",
            flexDirection: "column",
            transition: "margin-left 0.3s ease",
          }}
        >
          <Box
            component="main"
            sx={{
              flexGrow: 1,
              p: 3,
              background: "linear-gradient",
            }}
          >
            {children}
          </Box>
        </Box>
        <Footer />
      </Box>
    </>
  );
};

export default MainLayout;
