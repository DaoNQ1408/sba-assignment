import api from "./api";
import type { LoginResponse, LoginRequest } from "../types/auth";

export const authService = {
    login: async (credentials : LoginRequest): Promise<LoginResponse> => {
        const response = await api.post<LoginResponse>("/auth/login", credentials);

        if(response.data.token) {
            localStorage.setItem("token", response.data.token);
        }
        return response.data;
    },
    
    logout: () => {
        localStorage.removeItem("token");
    },

    isAuthenticated: (): boolean => {
        return !!localStorage.getItem("token");
    }
};
