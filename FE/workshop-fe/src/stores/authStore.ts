// src/stores/authStore.ts
import { create } from 'zustand';
import type {AuthStore, AuthCredentials, User} from '../types';

export const useAuthStore = create<AuthStore>((set) => ({
    user: null,
    isAuthenticated: false,
    isLoading: false,
    error: null,

    login: async (credentials: AuthCredentials) => {
        set({ isLoading: true, error: null });

        try {
            // Mock API call
            await new Promise(resolve => setTimeout(resolve, 1000));

            if (credentials.email === 'admin@example.com' &&
                credentials.password === 'password123') {
                const user: User = {
                    id: '1',
                    email: credentials.email,
                    firstName: 'Admin',
                    lastName: 'User',
                    avatar: `https://ui-avatars.com/api/?name=Admin+User`
                };

                localStorage.setItem('user', JSON.stringify(user));
                set({ user, isAuthenticated: true, isLoading: false });
            } else {
                set({ isLoading: false, error: 'Invalid credentials' });
            }
        } catch (error) {
            set({ isLoading: false, error: 'Login failed' });
        }
    },

    logout: () => {
        localStorage.removeItem('user');
        set({ user: null, isAuthenticated: false });
    },

    clearError: () => set({ error: null }),
}));