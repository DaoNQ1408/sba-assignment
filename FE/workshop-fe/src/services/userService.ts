import api from "./api";
import type {User} from "../types/auth";

export const userService = {
    async getUsers(): Promise<User[]> {
        const response = await api.get<User[]>(`/users`);
        return response.data;
    },
};
