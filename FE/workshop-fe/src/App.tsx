import React, { useEffect } from 'react';
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import { Home } from './pages/Home';
import { useAuthStore } from './stores/authStore';
import Login from './pages/Login';

const ProtectedRoute: React.FC<{ children: React.ReactNode }> = ({ children }) => {
  const isAuthenticated = useAuthStore(state => state.isAuthenticated);
  return isAuthenticated ? <>{children}</> : <Navigate to="/login" />;
};

function App() {
  const { isAuthenticated } = useAuthStore();


  // Auto-login if user data exists
  useEffect(() => {
    const userData = localStorage.getItem('user');
    if (userData && !isAuthenticated) {
      const user = JSON.parse(userData);
      useAuthStore.setState({ user, isAuthenticated: true });
    }
  }, [isAuthenticated]);


  return (
      <BrowserRouter>
        <Routes>
          <Route
              path="/login"
              element={isAuthenticated ? <Navigate to="/" /> : <Login/>}
          />
          <Route
              path="/"
              element={
                <ProtectedRoute>
                  <Home />
                </ProtectedRoute>
              }
          />
          <Route path="*" element={<Navigate to="/" />} />
        </Routes>
      </BrowserRouter>
  );
}

export default App;
