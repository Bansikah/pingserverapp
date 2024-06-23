import { Status } from "../enum/status.enum";
import express from 'express';


export interface Server {
    id: number;
    ipAddress: string;
    name: string;
    memory: string;
    type: string;
    imageUrl: string;
    status: Status;
}