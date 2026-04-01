"use client";

import { useState } from "react";

type DriverDocument = {
    id: number | null;
    driverId: string;
    fileName: string;
    status: string;
    rejectionReason: string | null;
};

export default function Page() {
    const [driverId, setDriverId] = useState("");
    const [fileName, setFileName] = useState("");
    const [result, setResult] = useState<DriverDocument | null>(null);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState("");

    async function handleValidate() {
        setLoading(true);
        setError("");
        setResult(null);

        try {
            const response = await fetch(
                `http://localhost:8080/api/driver-documents?driverId=${encodeURIComponent(driverId)}&fileName=${encodeURIComponent(fileName)}`
            );

            if (!response.ok) {
                throw new Error("Request failed");
            }

            const data: DriverDocument = await response.json();
            setResult(data);
        } catch {
            setError("Could not connect to the backend.");
        } finally {
            setLoading(false);
        }
    }

    return (
        <main className="min-h-screen bg-neutral-950 text-white flex items-center justify-center p-6">
            <div className="w-full max-w-md rounded-2xl border border-white/10 bg-white/5 p-6 shadow-2xl">
                <h1 className="text-2xl font-semibold mb-2">Driver Document Validation</h1>
                <p className="text-sm text-white/70 mb-6">
                    Demo UI connected to the Kotlin + Spring Boot backend.
                </p>

                <div className="space-y-4">
                    <div>
                        <label className="block text-sm mb-2">Driver ID</label>
                        <input
                            value={driverId}
                            onChange={(e) => setDriverId(e.target.value)}
                            placeholder="123"
                            className="w-full rounded-lg border border-white/10 bg-black/30 px-3 py-2 outline-none"
                        />
                    </div>

                    <div>
                        <label className="block text-sm mb-2">File name</label>
                        <input
                            value={fileName}
                            onChange={(e) => setFileName(e.target.value)}
                            placeholder="expired-license.pdf"
                            className="w-full rounded-lg border border-white/10 bg-black/30 px-3 py-2 outline-none"
                        />
                    </div>

                    <button
                        onClick={handleValidate}
                        disabled={loading || !driverId || !fileName}
                        className="w-full rounded-lg bg-white text-black font-medium py-2 disabled:opacity-50"
                    >
                        {loading ? "Validating..." : "Validate Document"}
                    </button>
                </div>

                {error && (
                    <div className="mt-4 rounded-lg border border-red-500/30 bg-red-500/10 p-3 text-sm text-red-200">
                        {error}
                    </div>
                )}

                {result && (
                    <div className="mt-6 rounded-xl border border-white/10 bg-black/20 p-4">
                        <h2 className="text-lg font-semibold mb-3">Result</h2>
                        <div className="space-y-2 text-sm">
                            <p><span className="text-white/60">ID:</span> {result.id}</p>
                            <p><span className="text-white/60">Driver ID:</span> {result.driverId}</p>
                            <p><span className="text-white/60">File name:</span> {result.fileName}</p>
                            <p><span className="text-white/60">Status:</span> {result.status}</p>
                            <p><span className="text-white/60">Reason:</span> {result.rejectionReason ?? "None"}</p>
                        </div>
                    </div>
                )}
            </div>
        </main>
    );
}
